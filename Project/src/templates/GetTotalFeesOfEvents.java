package templates;

import java.util.ArrayList;

import model.BeansEventDetailInfo;

public class GetTotalFeesOfEvents {
	public static int getTotalItemPrice(ArrayList<BeansEventDetailInfo> inCartBeansEventDetailInfoList) {
		int total = 0;
		for (BeansEventDetailInfo inCartBeansEventDetailInfoList2 : inCartBeansEventDetailInfoList) {
			total += inCartBeansEventDetailInfoList2.getFees();
		}
		return total;
	}
}
