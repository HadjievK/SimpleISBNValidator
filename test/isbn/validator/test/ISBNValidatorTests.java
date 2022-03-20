package isbn.validator.test;

import isbn.validator.ISBNValidator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ISBNValidatorTests {

  @Test
  public void checkAValidISBN() {
    ISBNValidator ISBNValidator = new ISBNValidator();
    boolean result = ISBNValidator.checkISBN("0140449116");
    assertTrue(result);
  }

  @Test
  public void ISBNEndsWithXAreValid() {
    ISBNValidator ISBNValidator = new ISBNValidator();
    boolean result = ISBNValidator.checkISBN("012000030X");
    assertTrue(result);
  }

  @Test
  public void checkAnInvalidISBN() {
    ISBNValidator ISBNValidator = new ISBNValidator();
    boolean result = ISBNValidator.checkISBN("0140449116");
    assertTrue(result);
  }

  @Test
  public void checkAValid13DigitISBN() {
    ISBNValidator ISBNValidator = new ISBNValidator();
    boolean result = ISBNValidator.checkISBN("9781853260087");
    assertTrue(result);
  }

  @Test(expected = NumberFormatException.class)
  public void nineDigitISBNAreNotAllowed() {
    ISBNValidator ISBNValidator = new ISBNValidator();
    boolean result = ISBNValidator.checkISBN("014044911");
  }

  @Test(expected = NumberFormatException.class)
  public void nonNumberISBNAreNotAllowed() {
    ISBNValidator ISBNValidator = new ISBNValidator();
    boolean result = ISBNValidator.checkISBN("assasasas");
  }

}
