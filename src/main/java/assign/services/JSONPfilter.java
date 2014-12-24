package assign.services;

import javax.servlet.*;
import java.io.IOException;

public class JSONPfilter implements Filter {
    private String callbackParameter;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter action");

//        HttpServletResponse res = (HttpServletResponse) response;
//        res.addHeader("Access-Control-Allow-Origin","*");
//        res.setHeader("Access-Control-Allow-Methods","GET,POST");
//        res.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");

        chain.doFilter(request, response);

     }

    @Override
    public void destroy() {

    }
}