use helpers::*;
use std::collections::*;

type Num = usize;

fn main() {
    init_input!(ii);

    let mut grid = vec![];

    for _ in 0..8 {
        if let Some(line) = ii.next_line() {
            grid.push(line.chars().collect::<Vec<_>>());
        }
    }

    println!("{}", solve(&mut grid));
}

fn solve(vec: &mut [Vec<char>]) -> Num {
    let mut sum = 0;

    for i in 0..vec.len() {
        for j in 0..vec[0].len() {
            if vec[i][j] == '#' {
                for k in 0..8 {
                    if vec[i][k] != '#' {
                        vec[i][k] = '0';
                    }
                }
                for k in 0..8 {
                    if vec[k][j] != '#' {
                        vec[k][j] = '0';
                    }
                }
            }
        }
    }

    // println!();
    // for i in 0..vec.len() {
    //     for j in 0..vec[0].len() {
    //         print!("{} ", vec[i][j]);
    //     }
    //     println!();
    // }

    for i in 0..vec.len() {
        for j in 0..vec[0].len() {
            if vec[i][j] == '.' {
                sum += 1;
            }
        }
    }
    sum
}

///
/// HELPERS
///
mod helpers {
    use std::io::{self, BufRead};
    use std::str::FromStr;
    #[macro_export]
    macro_rules! init_input {
        ($ii:ident) => {
            let stdin = std::io::stdin();
            let stdin_lock = stdin.lock();
            let mut $ii = In::new(stdin_lock);
        };
    }
    pub struct In<'a> {
        it: io::Lines<io::StdinLock<'a>>,
    }
    impl<'a> In<'a> {
        pub fn new(lock: io::StdinLock<'a>) -> Self {
            Self { it: lock.lines() }
        }
        pub fn get_num<T: FromStr>(&mut self) -> T
        where
            <T as FromStr>::Err: std::fmt::Debug,
        {
            self.it.next().unwrap().unwrap().parse::<T>().unwrap()
        }
        pub fn get_two<T: FromStr + Copy>(&mut self) -> (T, T)
        where
            <T as FromStr>::Err: std::fmt::Debug,
        {
            let vec = self.get_vec::<T>();
            (vec[0], vec[1])
        }
        pub fn get_three<T: FromStr + Copy>(&mut self) -> (T, T, T)
        where
            <T as FromStr>::Err: std::fmt::Debug,
        {
            let vec = self.get_vec::<T>();
            (vec[0], vec[1], vec[2])
        }
        pub fn get_vec<T: FromStr>(&mut self) -> Vec<T>
        where
            <T as FromStr>::Err: std::fmt::Debug,
        {
            let row = self.it.next().unwrap().unwrap();
            row.split_whitespace()
                .map(|n| n.parse::<T>().unwrap())
                .collect::<Vec<_>>()
        }
        pub fn next_line(&mut self) -> Option<String> {
            self.it.next().map(|line| line.unwrap())
        }
    }
}
