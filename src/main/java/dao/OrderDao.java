package dao;


        import model.Order;

        import java.util.List;

public interface OrderDao
{
    List<Order> getAll();

    void add(Order order);
}
