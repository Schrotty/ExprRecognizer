parser grammar MathFirst;

options {
    tokenVocab=MathFrags;
}

program : stat
        | program stat
        ;

stat    : expr NEWLINE
        | NEWLINE
        ;

expr    : term
        | expr (PLUS | MINUS) term
        ;

term    : fact
        | term (MULT | DIV) fact
        ;

fact    : INTEGER
        | BOPEN expr BCLOSE
        ;