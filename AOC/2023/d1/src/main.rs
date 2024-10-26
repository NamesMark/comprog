use std::fs;
use phf::phf_map;

const PATH: &str = "input.txt";

static NUMBERS: phf::Map<&'static str, &'static str> = phf_map! {
    "one" => "o1e",
    "two" => "t2o",
    "three" => "t3e",
    "four" => "4",
    "five" => "5e",
    "six" => "6",
    "seven" => "7n",
    "eight" => "e8t",
    "nine" => "n9e",
};

fn main() {
    let mut contents = fs::read_to_string(PATH).expect("Couldn't read lol");

    // for (w, num) in &NUMBERS {
    //     contents = contents.replace(*w, &num.to_string());
    // }
    
    let lines = contents.lines();
    let mut sum = 0;

    for line in lines {
        println!("{line}");
        let mut new_line: String = line.to_string();
        for (w, num) in &NUMBERS {
            new_line = new_line.replace(*w, &num.to_string());
        }
        println!("{new_line}");
        let digits: Vec<char> = new_line.chars().filter(|x| x.is_digit(10) ).collect();
        let old_sum = sum;
        let digit1 = digits.first().unwrap();~
        let digit2 = digits.last().unwrap();
        let mut number: String = "".to_string();
        number.push(*digit1);
        number.push(*digit2);
        let number: u32 = number.parse().unwrap();
        sum += number;
        println!("{old_sum} +{digit1}{digit2}, = {sum}");
    }
    println!("{sum}");
}