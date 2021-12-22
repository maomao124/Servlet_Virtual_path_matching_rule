package mao.servlet_virtual_path_matching_rule;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Project name(项目名称)：Servlet_Virtual_path_matching_rule
 * Package(包名): mao.servlet_virtual_path_matching_rule
 * Class(类名): VirtualPathServlet
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/22
 * Time(创建时间)： 14:25
 * Version(版本): 1.0
 * Description(描述)：
 * 当 Servlet 容器接收到请求后，容器会将请求的 URL 减去当前应用的上下文路径，使用剩余的字符串作为映射 URL 与 Servelt 虚拟路径进行匹配，
 * 匹配成功后将请求交给相应的 Servlet 进行处理。
 * 以 servletDemo 为例，若 URL 为“http://localhost:8080/servletDemo/myServlet”，
 * 其应用上下文是 servletDemo，容器会将“http://localhost:8080/servletDemo”去掉，使用剩余的“/myServlet”与 Servlet 虚拟路径进行匹配。
 * 匹配规则
 * Servlet 虚拟路径匹配规则有以下 4 种：
 * 完全路径匹配
 * 目录匹配
 * 扩展名匹配
 * 缺省匹配（默认匹配）
 *
 * 匹配规则	使用规则	虚拟路径	可访问的URL
 * 完全路径匹配
 * (精确匹配)	以/开始，不能包含通配符* 。
 * 必须完全匹配	/myServlet
 * /user/myServlet
 * /product/index.action	http://localhost:8080/servletDemo/myServlet
 * http://localhost:8080/servletDemo/user/myServlet
 * http://localhost:8080/servletDemo/product/index.action
 * 目录匹配	以/字符开头，并以/*结尾的字符串。
 * 用于路径匹配	/user/*
 * /*	http://localhost:8080/servletDemo/user/aaa
 * http://localhost:8080/servletDemo/aa
 * 扩展名匹配	以通配符*.开头的字符串。
 * 用于扩展名匹配	*.do
 * *.action
 * *.jsp	http://localhost:8080/servletDemo/user.do
 * http://localhost:8080/servletDemo/myServlet.action
 * http://localhost:8080/servletDemo/bb.jsp
 * 缺省匹配（默认匹配）	映射路径为/，表示这个 Servlet 为当前应用的缺省 Servlet 或默认 Servlet，默认处理无法匹配到虚拟路径的请求。
 * /	可以匹配任意请求 URL
 *
 * 匹配优先级
 * Servlet 虚拟路径的匹配优先级顺序为：全路径匹配（精确匹配）> 目录匹配 > 扩展名匹配 > 缺省匹配（默认匹配）。
 * Servlet 容器会从优先级高的虚拟路径开始匹配，匹配成功后就会立刻将请求交给相应的 Servlet 进行处理，不会再关注其他虚拟路径是否匹配成功。
 */

public class VirtualPathServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        // 向页面输出
        writer.write("本次访问的Servlet是:" + this.getServletName());
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doGet(req, resp);
    }

}
