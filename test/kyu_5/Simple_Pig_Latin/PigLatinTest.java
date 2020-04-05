package kyu_5.Simple_Pig_Latin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PigLatinTest {
    
    @Test
    public void FixedTests() {
        assertEquals("igPay atinlay siay oolcay", PigLatin.pigIt("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay", PigLatin.pigIt("This is my string"));
        assertEquals("elloHay orldway !", PigLatin.pigIt("Hello world !"));
        assertEquals("yMay amenay siay omTay ?", PigLatin.pigIt("My name is Tom ?"));
    }

}