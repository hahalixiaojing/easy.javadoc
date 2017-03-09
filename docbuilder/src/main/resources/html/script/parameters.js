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
        $.get("api/parameters" + window.location.search, function (data) {
            this.cls = data;
        }.bind(this));
    }
});