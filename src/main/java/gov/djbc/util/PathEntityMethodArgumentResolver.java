package gov.djbc.util;

import gov.djbc.spring.filter.Fentry;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Map;

public class PathEntityMethodArgumentResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(RequestObject.class);  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        String parameterName = parameter.getParameterName();
        System.out.println("nama parameter:" + parameterName);


        HttpServletRequest httpServletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        BufferedReader br = null;
//        br = httpServletRequest.getReader();
        String baris = "";

        byte[] inByte = new byte[httpServletRequest.getContentLength()];
        InputStream sin = httpServletRequest.getInputStream();
        sin.read(inByte);
        InputStream in = new ByteArrayInputStream(inByte);


        br = new BufferedReader(new InputStreamReader(in));
        ObjectMapper mapper = new ObjectMapper();
        Object f = null;
        try {
//           
            JsonParser jp = mapper.getJsonFactory().createJsonParser(br);
            jp = mapper.getJsonFactory().createJsonParser(br);
            JsonNode jn = mapper.readTree(jp);
            JsonNode jfent = jn.get(parameterName);
            f = mapper.readValue(jfent, parameter.getParameterType());

            br.mark(0);
            br.reset();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
//        while ((baris = br.readLine()) != null) {
//            System.out.println("entry json per parameter:" + baris);
//        }
//        br.mark(0);
////        br.reset();
        System.out.println("map" + f);


        return f;  //To change body of implemented methods use File | Settings | File Templates.
    }
}