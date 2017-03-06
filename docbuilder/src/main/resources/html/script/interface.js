Vue.filter("returnType", function (value) {
    var name = value.type.substring(value.type.lastIndexOf('.') + 1);
    if (value.array && name.lastIndexOf("[]") == -1) {
        return name + "[]";
    }
    return name;
});
Vue.filter("href", function (value) {
    return "type.html?type=" + value.type;
});
Vue.filter("anchor", function (value) {
    return "#" + value.name;

});
var app = new Vue({
    el: "#el",
    data: function () {
        return {
            interfaces: [],
            dir: []
        }
    },
    created: function () {
        $.get("api/interfaces" + window.location.search, function (data) {

            for (var i = 0; i < data.length; i++) {
                this.interfaces.push(data[i]);
                this.dir.push(data[i]);
            }

        }.bind(this));
    },
    methods: {
        go: function (m, interface) {
            window.location.href = "parameters.html?type=" + interface.name + "&method=" + m.name;
        },
        hilight: function (obj) {
            $("table caption a").css("color", "black")
            $("#" + obj.name.replace(new RegExp("\\.",'gm'),"\\\.")).css("color", "red");
        }
    }
});