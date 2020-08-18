package frontEnd;

import messageSystem.Address;

/**
 * @author s.arkhipov
 */
public class MessageRegistered extends MessageToFrontEnd {
    private String name;
    private boolean registered;

    public MessageRegistered(Address from, Address to, String name, boolean registered) {
        super(from, to);
        this.name = name;
        this.registered = registered;
    }

    @Override
    protected void exec(FrontEnd frontEnd) {
        frontEnd.registered(name, registered);
    }
}
