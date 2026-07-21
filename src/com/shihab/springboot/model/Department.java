package com.shihab.springboot.model;

/**
 * Simple enum used on Employee. Kept as an enum (rather than its own table)
 * to keep the demo focused - a common interview follow-up is "when would
 * you use an enum vs. a separate lookup table?".
 */
public enum Department {
    ENGINEERING,
    HUMAN_RESOURCES,
    SALES,
    FINANCE
}
