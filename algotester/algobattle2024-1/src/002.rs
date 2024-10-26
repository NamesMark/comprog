use std::io::{self, BufRead};

fn solve(nums: Vec<i32>) -> i32 {
    let mut growing = 0;

    nums.iter().enumerate().skip(1).fold(0, |mut acc, (i, num)| {
        if num > 
    })
}

fn main() {
    let stdin = io::stdin();
    let mut stdin_iterator = stdin.lock().lines();
    
    let t = stdin_iterator.next().unwrap().unwrap().trim().parse::<i32>().unwrap();

    let line = stdin_iterator.next().unwrap().unwrap();
    let nums: Vec<i32> = line.trim().split_whitespace().map(|n| n.parse().unwrap()).collect();

    if nums.len() == t {
        println!("{}", solve(nums));
    } else {
        eprintln!("Unexpected number of numbers");
    }
}
