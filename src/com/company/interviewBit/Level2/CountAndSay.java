package com.company.interviewBit.Level2;

public class CountAndSay {
    public class CountSay {
        public String countAndSay(int a) {
            if (a <= 0)
                return null;
            String result = "1";
            int i = 1;

            while (i < a) {
                StringBuilder sb = new StringBuilder();
                int count = 1;
                for (int j = 1; j < result.length(); j++) {
                    if (result.charAt(j) == result.charAt(j - 1))
                        count++;
                    else {
                        sb.append(count);
                        sb.append(result.charAt(j - 1));
                        count = 1;
                    }

                }
                sb.append(count);
                sb.append(result.charAt(result.length() - 1));
                result = sb.toString();
                i++;
                System.out.println(result);
            }
            System.out.println();
            return result;
        }
    }
}
