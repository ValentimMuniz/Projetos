package folha_de_pagamento;


public class RotinasGlobais {

    
    public int checkPasswordStrength(String password) {
        int strengthPercentage = 0;
        String[] partialRegexChecks = { ".*[a-z]+.*", // lower
                ".*[A-Z]+.*", // upper
                ".*[\\d]+.*", // digits
                ".*[@#$%.,!*/\']+.*" // symbols
        };
        if (password.matches(partialRegexChecks[0])) {
            strengthPercentage+=25;
        }
        if (password.matches(partialRegexChecks[1])) {
            strengthPercentage+=25;
        }
        if (password.matches(partialRegexChecks[2])) {
            strengthPercentage+=25;
        }
        if (password.matches(partialRegexChecks[3])) {
            strengthPercentage+=25;
        }
        return strengthPercentage;
    }

}
