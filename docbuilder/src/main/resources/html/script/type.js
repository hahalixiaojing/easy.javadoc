Vue.filter("type", function (value) {
    var name = value.type.substring(value.type.lastIndexOf('.') + 1);
    if (value.array && name.lastIndexOf("[]") == -1) {
        return name + "[]";
    }
    return name;
});
Vue.filter("href", function (value) {
    return "type.html?type=" + value.type;
});
var app = new Vue({
    el: "#el",
    data: function () {
        return {
            cls: []
        }
    },
    created: function () {
        $.get("api/model" + window.location.search, function (data) {
            this.cls = data;
        }.bind(this));
    }
});