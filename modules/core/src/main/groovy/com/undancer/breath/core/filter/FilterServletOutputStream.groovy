package com.undancer.breath.core.filter

import javax.servlet.ServletOutputStream

/**
 * Created by undancer on 14-1-20.
 */
class FilterServletOutputStream extends ServletOutputStream {

    DataOutputStream output

    FilterServletOutputStream(OutputStream output) {
        this.output = [output] as DataOutputStream
    }

    void write(int b) throws IOException {
        output.write(b)
    }

    void write(byte[] b) throws IOException {
        output.write(b)
    }

    void write(byte[] b, int off, int len) throws IOException {
        output.write(b, off, len)
    }
}
