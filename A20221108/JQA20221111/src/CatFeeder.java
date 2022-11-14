public class GatFeeder {
    public boolean shouldFeed(Cat cat) {
        return cat.getWeight() <= 8;

    }

    public void feed(Cat cat) {
        float currentWeight = cat.getWeight();
        cat.setWeight(currentWeight + 0.2f);
    }
}

