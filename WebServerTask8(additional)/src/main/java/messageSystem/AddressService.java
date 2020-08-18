package messageSystem;

import accountService.AccountService;
import frontEnd.FrontEnd;
import gameMechanics.GameMechanics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author s.arkhipov
 */
public class AddressService {
    private Address frontEnd;
    private Address gameMechanics;
    private List<Address> accountServiceList = new ArrayList<>();

    private AtomicInteger accountServiceCounter = new AtomicInteger();

    public void registerFrontEnd(FrontEnd frontEnd){
        this.frontEnd = frontEnd.getAddress();
    }

    public void registerGameMechanics(GameMechanics gameMechanics) {
        this.gameMechanics = gameMechanics.getAddress();
    }

    public void registerAccountService(AccountService accountService) {
        accountServiceList.add(accountService.getAddress());
    }

    public Address getFrontEndAddress() {
        return frontEnd;
    }

    public Address getGameMechanicsAddress() {
        return gameMechanics;
    }

    public synchronized Address getAccountServiceAddress() {
        final int index = accountServiceCounter.getAndIncrement() % accountServiceList.size();
        return accountServiceList.get(index);
    }
}
