package cookie.industry.extra;

import cookie.industry.extra.api.MachineTier;

public interface IMachine {
    MachineTier machineTier = null;

    MachineTier getMachineTier();

    boolean canProduce();

    void produceItem();
}
