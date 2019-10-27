package de.rubenmaurer;

import de.rubenmaurer.antlr.MathFirst;
import de.rubenmaurer.antlr.MathFrags;
import org.antlr.v4.runtime.*;

public class MathFirstReco {

    public static void main(String[] args) {
        System.out.println(recognizeExpression("10 * 2 / 2 + 4\r\n"));
    }

    static String recognizeExpression(String input) {
        CharStream stream = CharStreams.fromString(input);

        MathFrags lexer = new MathFrags(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        MathFirst parser = new MathFirst(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new RuntimeException(e);
            }
        });

        return parser.program().toStringTree(parser);
    }
}
