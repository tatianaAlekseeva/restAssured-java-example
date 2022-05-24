package tests;

import entities.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static application.Application.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.RandomGenerators.*;

public class ShoppingCartTests {

    @Test
    @DisplayName("Add selected item to the shopping cart")
    @Tag("add_item")
    public void addItemToCart() {
        int itemId = getItemId();
        String cookie = getCookie();
        String requestId = getRequestId();
        addToCart(requestId, cookie, itemId);

        Item addItem = getCartItem(cookie, requestId);
        String respProdId = addItem.getProd_id();
        String respCookie = addItem.getCookie();
        assertThat(respProdId, equalTo(String.valueOf(itemId)));
        assertThat(respCookie, equalTo(cookie));
    }

    @Test
    @DisplayName("Delete selected item from the shopping cart")
    @Tag("delete_item")
    public void deleteItemFromCart() {
        String requestId = getRequestId();
        String cookie = getCookie();
        testPrepareAction(cookie,requestId);

        deleteItem(requestId);
        List<Item> items = getCartContext(cookie);
        assertThat(items.size(), is(0));
    }
}


