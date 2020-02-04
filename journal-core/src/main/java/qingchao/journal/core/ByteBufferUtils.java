package qingchao.journal.core;

import java.nio.ByteBuffer;

public abstract class ByteBufferUtils {
    /**
     * Read the given byte buffer into a byte array
     *
     * This will <em>consume</em> the given {@link ByteBuffer}.
     */
    public static byte[] readBytes(ByteBuffer buffer) {
        return readBytes(buffer, 0, buffer.remaining());
    }

    /**
     * Read a byte array from the given offset and size in the buffer
     *
     * This will <em>consume</em> the given {@link ByteBuffer}.
     */
    public static byte[] readBytes(ByteBuffer buffer, int offset, int size) {
        final byte[] dest = new byte[size];
        buffer.get(dest, offset, size);
        return dest;
    }
}
