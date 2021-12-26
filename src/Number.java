public class Number {
    int value;
    boolean isRoman;

    Number(String str) throws Exception {
        setValue(numericCheck(str));
    }

    int numericCheck(String str) throws Exception {
        int number;

        try{
            number = Integer.parseInt(str);
        }
        catch (NumberFormatException ex){
            number = romanCheck(str);
        }
        if (number < 0 || number >10){
            throw new Exception("//т.к. принимаются только целые положительные римские и арабские числа до 10");
        }
        return number;
    }

    int romanCheck(String str) throws Exception{
        try {
            RomanNumers number = RomanNumers.valueOf(str);
            this.setRoman();
            return number.getValue();
        } catch ( IllegalArgumentException e ) {
            throw new Exception("//т.к. принимаются только целые положительные римские и арабские числа до 10");
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isRoman() {
        return isRoman;
    }

    public void setRoman() {
        isRoman = true;
    }
}
