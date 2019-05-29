/*
################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Read the zproject/README.md for information about making permanent changes. #
################################################################################
*/
package org.zeromq.czmq;

import java.util.stream.Stream;
import org.zeromq.tools.ZmqNativeLoader;

public class Zdigest implements AutoCloseable{
    static {
        Stream.of(
                "zmq",
                "uuid",
                "libsystemd",
                "lz4",
                "curl",
                "microhttpd",
                "czmq"
            )
            .forEach(lib -> {
                try {
                    ZmqNativeLoader.loadLibrary(lib);
                } catch (Exception e) {
                    System.err.println("[WARN] " + e.getMessage() +" from jar. Assuming it is installed on the system.");
                }
            });
        try {
            ZmqNativeLoader.loadLibrary("czmqjni");
        } catch (Exception e) {
            System.exit (-1);
        }
    }
    public long self;
    /*
    Constructor - creates new digest object, which you use to build up a
    digest by repeatedly calling zdigest_update() on chunks of data.
    */
    native static long __new ();
    public Zdigest () {
        /*  TODO: if __new fails, self is null...            */
        self = __new ();
    }
    public Zdigest (long pointer) {
        self = pointer;
    }
    /*
    Destroy a digest object
    */
    native static void __destroy (long self);
    @Override
    public void close () {
        __destroy (self);
        self = 0;
    }
    /*
    Add buffer into digest calculation
    */
    native static void __update (long self, byte [] buffer, long length);
    public void update (byte [] buffer, long length) {
        __update (self, buffer, length);
    }
    /*
    Return final digest hash data. If built without crypto support,
    returns NULL.
    */
    native static byte [] __data (long self);
    public byte [] data () {
        return __data (self);
    }
    /*
    Return final digest hash size
    */
    native static long __size (long self);
    public long size () {
        return __size (self);
    }
    /*
    Return digest as printable hex string; caller should not modify nor
    free this string. After calling this, you may not use zdigest_update()
    on the same digest. If built without crypto support, returns NULL.
    */
    native static String __string (long self);
    public String string () {
        return __string (self);
    }
    /*
    Self test of this class.
    */
    native static void __test (boolean verbose);
    public static void test (boolean verbose) {
        __test (verbose);
    }
}
