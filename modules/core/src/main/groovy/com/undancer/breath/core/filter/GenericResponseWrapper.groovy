package com.undancer.breath.core.filter

import javax.servlet.ServletOutputStream
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletResponseWrapper

/**
 * Created by undancer on 14-1-20.
 */
class GenericResponseWrapper extends HttpServletResponseWrapper {


    private ByteArrayOutputStream output
    int contentLength
    String contentType

    /**
     * Constructs a response adaptor wrapping the given response.
     *
     * @throws java.lang.IllegalArgumentException
     *             if the response is null
     */
    GenericResponseWrapper(HttpServletResponse response) {
        super(response)
        output = [] as ByteArrayOutputStream
    }

    byte[] getData() {
        output.toByteArray()
    }

    ServletOutputStream getOutputStream() {
        [output] as FilterServletOutputStream
    }

    PrintWriter getWriter() {
        [outputStream, true] as PrintWriter
    }

}
