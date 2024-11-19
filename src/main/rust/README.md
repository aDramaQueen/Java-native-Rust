# Rust
Pure Rust subproject that is generates some dynamic libraries

## Requirements

- Rust compiler
- Rust toolchain (for cross-compiling)

## Toolchains
(@see [Rust DOCs - Platform Support](https://doc.rust-lang.org/stable/rustc/platform-support.html#platform-support))

- rustup target add armv7-linux-androideabi   # for arm
- rustup target add i686-linux-android        # for x86
- rustup target add aarch64-linux-android     # for arm64
- rustup target add x86_64-linux-android      # for x86_64
- rustup target add x86_64-unknown-linux-gnu  # for linux-x86-64
- rustup target add x86_64-apple-darwin       # for darwin x86_64 (if you have an Intel MacOS)
- rustup target add aarch64-apple-darwin      # for darwin arm64 (if you have a M1 MacOS)
- rustup target add x86_64-pc-windows-gnu     # for win32-x86-64-gnu
- rustup target add x86_64-pc-windows-msvc    # for win32-x86-64-msvc
- ...
