package easy.javadoc.builder.doc;

import easy.javadoc.annotation.*;
import easy.javadoc.builder.IDocument;
import easy.javadoc.builder.model.*;
import org.apache.commons.lang3.StringUtils;
import sun.tools.jar.resources.jar;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class Document implements IDocument {

    private MethodParameterResolver methodParameterResolver;
    private MethodReturnTypeReslover methodReturnTypeReslover;

    private TypeFieldResolver typeFieldResolver = new TypeFieldResolver();
    private TypeMethodReslover typeMethodReslover;

    public Document() {
        this.methodParameterResolver = new MethodParameterResolver();
        this.methodReturnTypeReslover = new MethodReturnTypeReslover();
        this.typeMethodReslover = new TypeMethodReslover(this.methodParameterResolver, this.methodReturnTypeReslover);
    }

    @Override
    public InterfaceTypeModel[] findByBasepackage(String basepackage) throws Exception {
        String path = basepackage.replace('.', '/') + "/";
        URL url = this.getClass().getClassLoader().getResource(path);
        if (url == null) {
            return new InterfaceTypeModel[0];
        }

        if (url.getProtocol().equals("file")) {
            return this.findFromDirectory(basepackage, url.getFile());
        } else { //protocol = jar
            String jarfile = JarPathHelper.jarPath(url.getFile());

            List<InterfaceTypeModel> list = Arrays.asList(this.findFromJarFile(jarfile));
            Collections.sort(list, new Comparator<InterfaceTypeModel>() {
                @Override
                public int compare(InterfaceTypeModel o1, InterfaceTypeModel o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });

            return list.toArray(new InterfaceTypeModel[0]);
        }
    }

    @Override
    public ClassTypeModel findClassByName(String clazz) throws Exception {

        Class<?> cls = Class.forName(clazz);
        return this.loadClass(cls);
    }

    @Override
    public MethodModel[] loadAllMethod(String clazz) throws Exception {
        Class<?> cls = Class.forName(clazz);
        return this.loadAllMethod(cls);
    }

    @Override
    public ParameterModel[] findMethodParameters(String clazz, String method) throws Exception {
        MethodModel[] methods = this.loadAllMethod(clazz);

        for (MethodModel m : methods) {
            if (m.getName().endsWith(method)) {
                return m.getParameterModels();
            }
        }
        return new ParameterModel[0];
    }

    private InterfaceTypeModel[] findFromJarFile(String jarFile) throws Exception {

        List<Class<?>> classes = this.fromJar(jarFile);

        List<InterfaceTypeModel> interfaceTypeModels = new ArrayList<InterfaceTypeModel>();
        for (Class<?> cls : classes) {
            if (cls.isInterface() && cls.isAnnotationPresent(TypeDescriptor.class)) {
                TypeDescriptor typeDescriptor = cls.getAnnotation(TypeDescriptor.class);
                InterfaceTypeModel typeModel = new InterfaceTypeModel();
                typeModel.setName(cls.getName());
                typeModel.setDescription(typeDescriptor.description());

                typeModel.setMethodModels(this.loadAllMethod(cls));

                interfaceTypeModels.add(typeModel);
            }
        }
        return interfaceTypeModels.toArray(new InterfaceTypeModel[0]);
    }

    private InterfaceTypeModel[] findFromDirectory(String basePackage, String dir) {
        File file = new File(dir);
        List<InterfaceTypeModel> list = new ArrayList<InterfaceTypeModel>();

        try {
            this.findFromDirectory(file, basePackage, list);
        } catch (Exception e) {

        }
        return list.toArray(new InterfaceTypeModel[0]);
    }

    private void findFromDirectory(File f, String basePackage, List<InterfaceTypeModel> list) throws Exception {
        File[] files = f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().endsWith(".class");
            }
        });

        if (files != null) {
            for (File file : files)
                if (file.isDirectory()) {
                    this.findFromDirectory(file, basePackage + "." + file.getName().replace(".class", ""), list);
                } else {
                    String clazz = basePackage + "." + file.getName().replace(".class", "");
                    Class<?> cls = Class.forName(clazz);
                    if (cls != null && cls.isInterface() && cls.isAnnotationPresent(TypeDescriptor.class)) {
                        TypeDescriptor typeDescriptor = cls.getAnnotation(TypeDescriptor.class);
                        if (typeDescriptor != null) {
                            InterfaceTypeModel typeModel = new InterfaceTypeModel();
                            typeModel.setName(cls.getName());
                            typeModel.setDescription(typeDescriptor.description());

                            typeModel.setMethodModels(this.loadAllMethod(cls));

                            list.add(typeModel);
                        }
                    }
                }
        }
    }


    private MethodModel[] loadAllMethod(Class cls) {
        return this.typeMethodReslover.loadAllMethod(cls);
    }

    private ClassTypeModel loadClass(Class cls) {
        TypeDescriptor typeDescriptor = (TypeDescriptor) cls.getAnnotation(TypeDescriptor.class);

        ClassTypeModel classTypeModel = new ClassTypeModel();
        classTypeModel.setName(cls.getName());
        classTypeModel.setDescription(typeDescriptor.description());
        classTypeModel.setFieldModels(this.loadAllFields(cls));
        return classTypeModel;
    }

    private FieldModel[] loadAllFields(Class<?> clazz) {
        return this.typeFieldResolver.loadAllFields(clazz);

    }

    private ReturnTypeModel getMethodReturnType(Method m) throws Exception {
        return this.methodReturnTypeReslover.getMethodReturnType(m);
    }

    private ParameterModel[] loadAllParameter(Method method) throws Exception {
        return this.methodParameterResolver.loadAllParameter(method);
    }

    private List<Class<?>> fromJar(String jarFile) throws Exception {

        ArrayList<Class<?>> arrayList = new ArrayList<Class<?>>();
        JarFile jar = null;
        try {
            jar = new JarFile(new File(jarFile));
            Enumeration<JarEntry> entries = jar.entries();

            while (entries.hasMoreElements()) {
                JarEntry jarEntry = entries.nextElement();
                if (!jarEntry.getName().endsWith(".class")) {
                    continue;
                }

                String classpath = StringUtils.remove(jarEntry.getName()
                        .replace('/', '.'), ".class");

                Class<?> cls = Class.forName(classpath);

                arrayList.add(cls);
            }
            return arrayList;
        } finally {
            jar.close();
        }
    }
}
