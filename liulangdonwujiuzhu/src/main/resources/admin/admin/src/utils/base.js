const base = {
    get() {
        return {
            url : "http://localhost:8080/liulangdonwujiuzhu/",
            name: "liulangdonwujiuzhu",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/liulangdonwujiuzhu/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "流浪动物救助小程序"
        } 
    }
}
export default base
