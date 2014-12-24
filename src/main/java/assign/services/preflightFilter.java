package assign.services;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by marekbejda on 12/21/14.
 */
public class preflightFilter  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("Executing REST request filter " +request.getMethod());
//        When HttpMethod comes as OPTIONS, just acknowledge that it accepts...
        if ( request.getMethod().equals("OPTIONS") ) {
            System.out.println( "HTTP Method (OPTIONS) - Detected!" );
            // Just send a OK signal back to the browser

            HttpServletResponse resp = (HttpServletResponse) servletResponse;
            resp.reset();
            resp.addHeader("Access-Control-Allow-Origin","*");
            resp.addHeader("Access-Control-Allow-Methods","GET,POST");
            resp.addHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");

            resp.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
