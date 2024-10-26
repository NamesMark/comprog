class rndJava {
    void Main() {
        String sample = "This-is_mixed-Case_case-to_Convert";
        String expect = "ThisIsMixedCaseCaseToConvert";
        char previous = '.';
        char[] delimiters = {'-', '_'}; 
        String result = sample.chars().map(x -> {
                x = previous == '-' || previous == '_' ? x-20 : x;
                previous = x;
            }).collect();
        System.out.println(result == expect ? "Test passed!" : "Test didn't pass: expected " + expect + ", got "+ result);
    }
}