package solid.humank.coffeeshop.order.domainevents;

import lombok.Getter;
import lombok.Setter;
import solid.humank.coffeeshop.order.models.OrderItem;
import solid.humank.ddd.commons.baseclasses.DomainEvent;
import solid.humank.ddd.commons.baseclasses.EntityId;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderItemsChanged extends DomainEvent {
    public OrderItemsChanged(EntityId id, List<OrderItem> items, OffsetDateTime modifiedDate) {

        this.setEntityId(id);
        this.setChangedItems(items);
        this.setModifiedDate(modifiedDate);
    }

    @Getter
    @Setter
    private List<OrderItem> changedItems;

    @Getter
    @Setter
    private OffsetDateTime modifiedDate;

    @Override
    protected Iterable<Object> getDerivedEventEqualityComponents() {
        List<Object> collection = new ArrayList<>();
        collection.add(super.entityId);
        for (OrderItem item : this.changedItems) {
            collection.add(item);
        }
        return collection;
    }
}