package org.jpwh.model.fetching.readonly;

import org.jpwh.model.Constants;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@org.hibernate.annotations.Immutable // Also works on collection
public class Bid {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    protected Item item;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    protected User bidder;

    @NotNull
    protected BigDecimal amount;

    public Bid() {
    }

    public Bid(Item item, User bidder, BigDecimal amount) {
        this.item = item;
        this.amount = amount;
        this.bidder = bidder;
    }

    public Long getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getBidder() {
        return bidder;
    }

    public void setBidder(User bidder) {
        this.bidder = bidder;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    // ...
}
