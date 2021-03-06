package ptolemy;
/* Generated by Ptolemy II (http://ptolemy.eecs.berkeley.edu)
Copyright (c) 2005-2009 The Regents of the University of California.
All rights reserved.
Permission is hereby granted, without written agreement and without
license or royalty fees, to use, copy, modify, and distribute this
software and its documentation for any purpose, provided that the above
copyright notice and the following two paragraphs appear in all copies
of this software.
IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY
FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES
ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
SUCH DAMAGE.
THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
CALIFORNIA HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
ENHANCEMENTS, OR MODIFICATIONS.
*/
public class Model {
    /* Generate type resolution code for .Model */
    // ConstantsBlock from codegen/java/kernel/SharedCode.j
    private final short TYPE_Token = -1;
    // #define PTCG_TYPE_Boolean 0
    private final short TYPE_Boolean = 0;
    // #define FUNC_new 0
    // #define FUNC_isCloseTo 1
    // #define FUNC_delete 2
    // #define FUNC_convert 3
    public class Token {
        private Short type;
        Object payload;
    public Token() {};
        public Short getType() {
            return type;
        }
        public Object getPayload() {
            return payload;
        }
        /* BooleanToken Boolean;
        */
    }
    Token emptyToken; /* Used by *_delete() and others. */
    // Token Boolean_new (Token thisToken, Token... tokens);  From codegen/java/kernel/SharedCode.j
    // Token Boolean_equals (Token thisToken, Token... tokens);  From codegen/java/kernel/SharedCode.j
    // Token Boolean_isCloseTo (Token thisToken, Token... tokens);  From codegen/java/kernel/SharedCode.j
    // Token Boolean_convert (Token thisToken, Token... tokens);  From codegen/java/kernel/SharedCode.j
    /* We share one method between all scalar types so as to reduce code size. */
    Token scalarDelete(Token token, Token... tokens) {
        /* We need to return something here because all the methods are declared
        * as returning a Token so we can use them in a table of functions.
        */
        return emptyToken;
    }
    Integer StringtoInteger(String string) {
        return Integer.valueOf(string);
    }
    Long StringtoLong(String string) {
        return Long.valueOf(string);
    }
    Integer DoubletoInteger(Double d) {
        return Integer.valueOf((int)Math.floor(d.doubleValue()));
    }
    Double IntegertoDouble(Integer i) {
        return Double.valueOf(i.doubleValue());
    }
    Long IntegertoLong(int i) {
        return Long.valueOf(i);
    }
    String IntegertoString(int i) {
        return Integer.toString(i);
    }
    String LongtoString(long l) {
        return Long.toString(l);
    }
    String DoubletoString(double d) {
        return Double.toString(d);
    }
    String BooleantoString(boolean b) {
        return Boolean.toString(b);
    }
    String UnsignedBytetoString(byte b) {
        return Byte.toString(b);
    }
    private final int NUM_TYPE = 1;
    private final int NUM_FUNC = 4;
    //Token (*functionTable[NUM_TYPE][NUM_FUNC])(Token, ...)= {
    //	{Boolean_new, Boolean_equals, scalarDelete, Boolean_convert}
    //};
    // make a new integer token from the given value.
    Token Boolean_new(boolean b) {
        Token result = new Token();
        result.type = TYPE_Boolean;
        result.payload = Boolean.valueOf(b);
        return result;
    }
    Token Boolean_equals(Token thisToken, Token... tokens) {
        Token otherToken;
        otherToken = tokens[0];
        return Boolean_new(
        ( (Boolean)thisToken.payload && (Boolean)otherToken.payload ) ||
        ( !(Boolean)thisToken.payload && !(Boolean)otherToken.payload ));
    }
    /* Instead of Boolean_delete(), we call scalarDelete(). */
    Token Boolean_convert(Token token, Token... tokens) {
        switch (token.type) {
            case TYPE_Boolean:
            return token;
            default:
            throw new RuntimeException("Boolean_convert(): Conversion from an unsupported type.: " + token.type);
        }
    }
    /* end shared code */
    /* Model_Discard's input variable declarations. */
    static int Model_Discard_input[] = new int[1];
    /* Director has a period attribute, so we track current time. */
    double _currentTime = 0;
    /* Provide the period attribute as constant. */
    public final static double PERIOD = 0.5;
    /* end preinitialize code */
    public void initialize() {
        /* The initialization of the director. */
    }
    public void wrapup() {
        /* The wrapup of the director. */
    }
    public static void main(String [] args) throws Exception {
        Model model = new Model();
        model.initialize();
        model.execute();
        model.doWrapup();
        System.exit(0);
    }
    public void execute() throws Exception {
        int iteration;
        for (iteration = 0; iteration < 10; iteration ++) {
            run();
        }
    }
    public void run() throws Exception {
        /* The firing of the StaticSchedulingDirector */
        /* Fire Model_Const */
        Model_Discard_input[0] = 1;
        /* ....Begin updateOffset....Model_Const_trigger */
        /*
        ....Begin updateConnectedPortsOffset....Model_Const_output */
        /*
        ....End updateConnectedPortsOffset....Model_Const_output */
        /* Fire Model_Discard */
        // consume the input token.
        ;
        //Model_Discard_input[0];
        /* ....Begin updateOffset....Model_Discard_input */
        /*
        ....End updateOffset....Model_Discard_input */
        /* The postfire of the director. */
        _currentTime += 0.5;
    }
    public void doWrapup() throws Exception {
    }
}
