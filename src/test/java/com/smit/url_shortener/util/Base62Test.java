package com.smit.url_shortener.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class Base62Test {
    @Test
    void encodeTenReturnsLowercaseA(){
        String result =  Base62.encode(10);
        assertThat(result).isEqualTo("a");
    }

    @Test
    void encodeSixtyTwoReturnTen(){
        String result =  Base62.encode(62);
        assertThat(result).isEqualTo("10");
    }

    @Test
    void decodeTenReturnsSixtyTwo(){
        long result =  Base62.decode("10");
        assertThat(result).isEqualTo(62);
    }
    @Test
    void decodeEmptyStringThrows() {
        assertThatThrownBy(() -> Base62.decode(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void encodeMinusOneThrows() {
        assertThatThrownBy(() -> Base62.encode(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
