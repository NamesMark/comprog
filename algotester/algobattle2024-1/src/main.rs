use std::io::{self, BufRead};
use std::collections::HashSet;

fn solve(n: usize, s: &str) -> String {
    for c in s.chars() {
        
    }
}

fn main() {
    let stdin = io::stdin();
    let mut stdin_iterator = stdin.lock().lines();
    
    let n = stdin_iterator.next().unwrap().unwrap().parse::<usize>().unwrap();

    let s = stdin_iterator.next().unwrap().unwrap();


    let result = solve(n, &s);

    println!("{}", result);
}
