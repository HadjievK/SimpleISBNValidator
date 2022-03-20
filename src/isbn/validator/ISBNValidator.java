package isbn.validator;

public class ISBNValidator {

  public static final int LONG_ISBN_LENGTH = 13;
  public static final int SHORT_ISBN_LENGTH = 10;
  public static final int LONG_ISBN_MULTIPLIER = 10;
  public static final int SHORT_ISBN_MULTIPLIER = 11;

  public boolean checkISBN(String isbn) {

    if (isbn.length() == LONG_ISBN_LENGTH) {
      return isThisAValidLongISBN(isbn);
    } else {
      if (isbn.length() != 10) throw new NumberFormatException("isbn can not contains 9 digits");
      return isThisAValidShortISBN(isbn);
    }
  }

  private boolean isThisAValidShortISBN(String isbn) {
    int total = 0;
    for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
      if (!Character.isDigit(isbn.charAt(i))) {
        if (i == 9 && isbn.charAt(i) == 'X') {
          total += 10;
        } else {
          throw new NumberFormatException("isbn can contain only digits");
        }
      } else {
        total += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
      }
    }
    return total % SHORT_ISBN_MULTIPLIER == 0;
  }

  private boolean isThisAValidLongISBN(String isbn) {
    int total = 0;
    for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
      if (i % 2 == 0) {
        total += Character.getNumericValue(isbn.charAt(i));
      } else {
        total += Character.getNumericValue(isbn.charAt(i)) * 3;
      }
    }
    return total % LONG_ISBN_MULTIPLIER == 0;
  }
}
