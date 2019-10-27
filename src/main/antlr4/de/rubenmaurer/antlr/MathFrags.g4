lexer grammar MathFrags;

PLUS
        : '+'
        ;

MINUS
        : '-'
        ;

MULT
        : '*'
        ;

DIV
        : '/'
        ;

BOPEN
        : '('
        ;

BCLOSE
        : ')'
        ;

INTEGER
        : [0-9]+
        ;

NEWLINE
        : '\n'
        | '\r'
        | '\r\n'
        ;

WS      : [ \t\r\n]+ -> skip
        ;