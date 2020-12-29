

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class FracCalcTestExtensions
{
    // Extensions only
    @Test public void multipleOps1() {assertEquals("-20/21", FracCalc.produceAnswer("1_2/3 + 5/4 + 5_5/4 - 2_2/4 / -5_6/3"));}
    @Test public void multipleOps2() {assertEquals("4", FracCalc.produceAnswer("1 + 3 + -3 - -3"));}
    @Test public void multipleOps3() {assertEquals("0", FracCalc.produceAnswer("12 * 18 * 18 * 0"));}
    @Test public void multipleOps4() {assertEquals("3_47/60", FracCalc.produceAnswer("20/8 + 3_1/3 - 4/5 - 5/4"));}
    @Test public void multipleOps5() {assertEquals("1", FracCalc.produceAnswer("12345 - 12345 + 12345 - 12345 + 1"));}
    @Test public void multipleOps6() {assertEquals("0", FracCalc.produceAnswer("0 * 0 / 1 / 4/6 / 2_3/4"));}
    @Test public void multipleOps7() {assertEquals("-1", FracCalc.produceAnswer("1/5 + 1/5 + 1/5 + 1/5 + 1/5 - 2"));}
    @Test public void multipleOps8() {assertEquals("0", FracCalc.produceAnswer("-4 + 1 + 1 + 1 + 1"));}
    @Test public void multipleOps9() {assertEquals("4_1/2", FracCalc.produceAnswer("16/4 / 3/2 * 3/2 + 1/2"));}
    @Test public void multipleOps10() {assertEquals("0", FracCalc.produceAnswer("12457 / -1 + 12457"));}
    @Test public void multipleOps11() {assertEquals("7", FracCalc.produceAnswer("5_3/4 - -6_8/8 - 5_3/4"));}
    @Test public void multipleOps12() {assertEquals("4", FracCalc.produceAnswer("2 * 3 - 6 + 1_1/2 + 1/2 - 1/2 - 1/2 + 3"));}
    @Test public void multipleOps13() {assertEquals("-4", FracCalc.produceAnswer("2 * 3 - 6 + -1_1/2 + -1/2 - -1/2 - -1/2 - 3"));}
    @Test public void multipleOps14() {assertEquals("4", FracCalc.produceAnswer("20 / 5 * -1 + 8"));}
}
