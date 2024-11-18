extern crate cbindgen;

use std::env;
use cbindgen::Config;

/// Generates C header files that may be consumed by another process, to natively call the Rust code!
///
/// The remaining Project must be compiled to dynamic libraries.
///
/// @see https://github.com/mozilla/cbindgen/blob/master/docs.md
fn main() {
    let crate_dir = env::var("CARGO_MANIFEST_DIR").unwrap();
    let config = Config::from_file("cbindgen.toml").unwrap();

    cbindgen::Builder::new()
        .with_config(config)
        .with_crate(crate_dir)
        .generate()
        .expect("Unable to generate C header files for Java bindings")
        .write_to_file("bindings.h");
}
