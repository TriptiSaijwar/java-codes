package com.company.GoogleInterviewQuestions;

public class HireLanguage {
    public void TestForValidLanguage()
    {
        String languageWord = "HHIIRREEHIREHHHIIIRRREEEE";
        boolean isValid = IsValidLanguage(languageWord, "HIRE");
    }

    public boolean IsValidLanguage(String languageWords, String language)
    {
        int counter = 0;
        int languageLength = -1;

        int languageIndex = 0;
        for (int i = 0; i < languageWords.length(); i++)
        {
            if (languageWords.charAt(i) == language.charAt(languageIndex)){}

            else if (languageWords.charAt(i) == language.charAt((languageIndex + 1)%language.length()))
            {
                if (languageLength == -1)
                {
                    languageLength = counter;
                }

                if (counter != languageLength)
                {
                    return false;
                }

                if ((languageIndex + 1) >= language.length())
                {
                    if (languageLength != counter)
                    {
                        return false;
                    }
                    //Reset the language length for the new word.
                    languageLength = -1;
                }
                languageIndex = (languageIndex + 1)%language.length();
                counter = 0;
            }
            else
            {
                return false;
            }
            counter++;
        }

        return counter == languageLength;
    }
}
