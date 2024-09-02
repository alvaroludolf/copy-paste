package br.com.loom.copypaste;

import java.util.*;
import java.util.stream.Collectors;

import static br.com.loom.copypaste.Location.*;
import static br.com.loom.copypaste.WarehouseEntity.BERLIN;
import static br.com.loom.copypaste.WarehouseEntity.PARIS;

public class Solution {

    public static void main(String[] args) {

        // TODO: print out the statistic

        StatisticsService statisticsService = new StatisticsService();

        System.out.println("Most sold: " + statisticsService.getMostSold());
    }
}

class StatisticsService {

    // TODO: get the most sold 5 articles among all warehouses
    public List<String> getMostSold() {
        return new OrderProvider().loadPastOrders().stream()
                .flatMap(o -> o.getArticles().stream())
                .collect(Collectors.groupingBy(a -> a))
                .entrySet().stream()
                .sorted(Comparator.comparingInt(s -> -s.getValue().size()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
                .subList(0, 5);
    }

    // TODO: get the most sold 5 articles of a warehouse
}

class OrderProvider {

    public List<CustomerOrder> loadPastOrders() {
        return LocalDataSetProvider.localOrderDataSet();
    }
}

class OrderService {

    public WarehouseEntity findOrderWarehouse(String orderId) {
        return LocalDataSetProvider.localOrderToWarehouseMapping().get(orderId);
    }
}

class WarehouseItem {
    private final String id;
    private final String article;
    private final Location location;
    private final WarehouseEntity warehouseEntity;

    public WarehouseItem(String id, String article, Location location, WarehouseEntity warehouseEntity) {
        this.id = id;
        this.article = article;
        this.location = location;
        this.warehouseEntity = warehouseEntity;
    }

    public String getId() {
        return id;
    }

    public String getArticle() {
        return article;
    }

    public Location getLocation() {
        return location;
    }

    public WarehouseEntity getWarehouseEntity() {
        return warehouseEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarehouseItem item = (WarehouseItem) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(article, item.article) &&
                location == item.location &&
                warehouseEntity == item.warehouseEntity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, article, location, warehouseEntity);
    }

    @Override
    public String toString() {
        return "WarehouseItem{" +
                "id='" + id + '\'' +
                ", article='" + article + '\'' +
                ", location=" + location +
                ", warehouse=" + warehouseEntity +
                '}';
    }
}

enum Location {
    HALL_1, HALL_2, HALL_3
}

class CustomerOrder {
    private final String orderId;
    private final String client;
    private final String deliveryCountry;
    private final List<String> articles;

    public CustomerOrder(String orderId, String client, String deliveryCountry, List<String> articles) {
        this.orderId = orderId;
        this.client = client;
        this.deliveryCountry = deliveryCountry;
        this.articles = articles;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getClient() {
        return client;
    }

    public String getDeliveryCountry() {
        return deliveryCountry;
    }

    public List<String> getArticles() {
        return articles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOrder order = (CustomerOrder) o;
        return Objects.equals(orderId, order.orderId) &&
                Objects.equals(client, order.client) &&
                Objects.equals(deliveryCountry, order.deliveryCountry) &&
                Objects.equals(articles, order.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, client, deliveryCountry, articles);
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "orderId=" + orderId +
                ", client='" + client + '\'' +
                ", deliveryCountry='" + deliveryCountry + '\'' +
                ", articles=" + articles +
                '}';
    }
}

enum WarehouseEntity {
    BERLIN, PARIS, MILAN
}

/*
 * --------------------------------------------------------------
 * ---------------------- TEST DATA SET -------------------------
 * --------------------------------------------------------------
 */
class LocalDataSetProvider {

    public static List<WarehouseItem> localItemDataSet() {
        List<WarehouseItem> items = new ArrayList<>();

        items.add(new WarehouseItem("item-id-1", "article-1", HALL_1, BERLIN));
        items.add(new WarehouseItem("item-id-2", "article-2", HALL_1, BERLIN));
        items.add(new WarehouseItem("item-id-3", "article-3", HALL_2, BERLIN));
        items.add(new WarehouseItem("item-id-4", "article-4", HALL_3, BERLIN));
        items.add(new WarehouseItem("item-id-5", "article-5", HALL_1, BERLIN));
        items.add(new WarehouseItem("item-id-6", "article-5", HALL_2, BERLIN));
        items.add(new WarehouseItem("item-id-7", "article-6", HALL_3, BERLIN));
        items.add(new WarehouseItem("item-id-8", "article-6", HALL_3, BERLIN));
        items.add(new WarehouseItem("item-id-9", "article-7", HALL_2, BERLIN));
        items.add(new WarehouseItem("item-id-10", "article-7", HALL_3, BERLIN));
        items.add(new WarehouseItem("item-id-11", "article-7", HALL_1, BERLIN));
        items.add(new WarehouseItem("item-id-12", "article-8", HALL_2, BERLIN));
        items.add(new WarehouseItem("item-id-13", "article-8", HALL_2, BERLIN));
        items.add(new WarehouseItem("item-id-14", "article-8", HALL_2, BERLIN));
        items.add(new WarehouseItem("item-id-15", "article-8", HALL_3, BERLIN));
        items.add(new WarehouseItem("item-id-16", "article-9", HALL_1, BERLIN));
        items.add(new WarehouseItem("item-id-17", "article-9", HALL_2, BERLIN));
        items.add(new WarehouseItem("item-id-18", "article-9", HALL_3, BERLIN));
        items.add(new WarehouseItem("item-id-19", "article-9", HALL_2, BERLIN));
        items.add(new WarehouseItem("item-id-20", "article-9", HALL_1, BERLIN));
        items.add(new WarehouseItem("item-id-21", "article-1", HALL_1, PARIS));
        items.add(new WarehouseItem("item-id-22", "article-1", HALL_1, PARIS));
        items.add(new WarehouseItem("item-id-23", "article-1", HALL_2, PARIS));
        items.add(new WarehouseItem("item-id-24", "article-2", HALL_3, PARIS));
        items.add(new WarehouseItem("item-id-25", "article-2", HALL_1, PARIS));
        items.add(new WarehouseItem("item-id-26", "article-3", HALL_2, PARIS));
        items.add(new WarehouseItem("item-id-27", "article-4", HALL_3, PARIS));
        items.add(new WarehouseItem("item-id-28", "article-5", HALL_3, PARIS));
        items.add(new WarehouseItem("item-id-29", "article-6", HALL_2, PARIS));
        items.add(new WarehouseItem("item-id-30", "article-7", HALL_3, PARIS));

        return items;
    }

    public static List<CustomerOrder> localOrderDataSet() {
        List<CustomerOrder> orders = new ArrayList<>();

        List<String> articles1 = new ArrayList<>();
        articles1.add("article-5");
        articles1.add("article-9-top-worldwide");
        articles1.add("article-8");
        orders.add(new CustomerOrder("order-1", "client-1", "DE", articles1));

        List<String> articles2 = new ArrayList<>();
        articles2.add("article-1");
        articles2.add("article-9-top-worldwide");
        articles2.add("article-6");
        orders.add(new CustomerOrder("order-2", "client-2", "DE", articles2));

        List<String> articles3 = new ArrayList<>();
        articles3.add("article-5");
        articles3.add("article-5");
        articles3.add("article-5");
        articles3.add("article-4");
        articles3.add("article-4");
        articles3.add("article-3");
        articles3.add("article-2");
        articles3.add("article-2");
        orders.add(new CustomerOrder("order-3", "client-3", "DE", articles3));

        List<String> articles4 = new ArrayList<>();
        articles4.add("article-7-top-berlin");
        articles4.add("article-7-top-berlin");
        articles4.add("article-7-top-berlin");
        articles4.add("article-7-top-berlin");
        articles4.add("article-7-top-berlin");
        articles4.add("article-7-top-berlin");
        articles4.add("article-7-top-berlin");
        articles4.add("article-4");
        articles4.add("article-5");
        orders.add(new CustomerOrder("order-4", "client-4", "DE", articles4));

        List<String> articles5 = new ArrayList<>();
        articles5.add("article-9-top-worldwide");
        articles5.add("article-9-top-worldwide");
        orders.add(new CustomerOrder("order-5", "client-5", "DE", articles5));

        List<String> articles6 = new ArrayList<>();
        articles6.add("article-6");
        articles6.add("article-6");
        articles6.add("article-6");
        articles6.add("article-8");
        articles6.add("article-3");
        articles6.add("article-9-top-worldwide");
        articles6.add("article-9-top-worldwide");
        articles6.add("article-9-top-worldwide");
        articles6.add("article-9-top-worldwide");
        orders.add(new CustomerOrder("order-6", "client-6", "FR", articles6));

        List<String> articles7 = new ArrayList<>();
        articles7.add("article-9-top-worldwide");
        articles7.add("article-8");
        articles7.add("article-8");
        articles7.add("article-8");
        articles7.add("article-8");
        articles7.add("article-8");
        articles7.add("article-8");
        articles7.add("article-6");
        articles7.add("article-6");
        articles7.add("article-3");
        articles7.add("article-4");
        orders.add(new CustomerOrder("order-7", "client-7", "FR", articles7));

        return orders;
    }

    public static Map<String, WarehouseEntity> localOrderToWarehouseMapping() {
        Map<String, WarehouseEntity> orderToWarehouse = new HashMap<>();
        orderToWarehouse.put("order-1", BERLIN);
        orderToWarehouse.put("order-2", BERLIN);
        orderToWarehouse.put("order-3", BERLIN);
        orderToWarehouse.put("order-4", BERLIN);
        orderToWarehouse.put("order-5", BERLIN);
        orderToWarehouse.put("order-6", PARIS);
        orderToWarehouse.put("order-7", PARIS);

        return orderToWarehouse;
    }
}