package cn.airen.main;

import spark.route.RouteOverview;

import static spark.Spark.get;

/**
 *
 * Created by ARX-12 on 2016/12/24.
 */
public class Main {
//    public static void main(String[] args) {
//        get("/hello", (req, res) -> "Hello World");
//
//
//    }
//public static void main(String[] args) {
//
//    get(new Route("/hello") {
//        @Override
//        public Object handle(Request request, Response response) {
//            return "Hello World!";
//        }
//    });
//
//}

    /**
     *
     * @param args
     * 总结:
     * 原理:
     * 这其实就是一个java项目,最终会被打包成一个jar
     * 当使用这个jar的时候其实就是一个调用了这个jar的main方法
     * main方法调用了,是不会停止的.
     * mian方法里面的其实就是使用了jetty容器开启了一个服务器,里面设置了端口号(默认:4567),
     * 在这个get方法里面复写了handle(req,resp)的方法,使用了lambda的编程方式.
     * 同时也提供了获取参数的方法 req.params("name") req.splat()[x]
     * 所以:只要在这个类注入service,然后取出参数,让service去调用就可以了
     */
    public static void main(String[] args) {
        get("/hello/:name",(request,response)-> "Hello:"+request.params(":name"));

        get("/say/*/to/*",(request,response)->{
            return "param1:"+request.splat()[0]+"param2:"+request.splat()[1];
        });
        //可以看到所有能去的路径
        RouteOverview.enableRouteOverview("/my/overview/path");

    }

}
