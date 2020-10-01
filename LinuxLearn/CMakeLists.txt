cmake_minimum_required(VERSION 3.17)
project(LinuxLearn C)

set(CMAKE_C_STANDARD 99)

add_library(LinuxLearn library.c library.h read_fifo.c write_fifo.c server.c)