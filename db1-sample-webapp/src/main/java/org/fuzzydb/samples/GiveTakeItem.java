package org.fuzzydb.samples;

import com.wwm.db1.spring.annotation.BackingClass;


@BackingClass(likemynds.app.domain.ProfileIndexEntry.class)
public class GiveTakeItem extends BaseEntity {

	/**
	 * Public constructor needed by some frameworks
	 */
	public GiveTakeItem() {
	}
	
	public GiveTakeItem(String desc) {
		this.description = desc;
	}

//    <string>ScreenName</string>
//    <string>Location</string>
//    <string>Place</string>
//    <string>SummaryTag</string>
//    <string>fmCategory</string>
//    <string>DeliveryType</string>
//    <string>Type</string>
//    <string>ItemStatus</string>
//    <string>HeadShot</string>


	private String screenName;

	private String summaryTag;
	
	private String fmCategory;
	

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getSummaryTag() {
		return summaryTag;
	}

	public void setSummaryTag(String summaryTag) {
		this.summaryTag = summaryTag;
	}

	public String getFmCategory() {
		return fmCategory;
	}

	public void setFmCategory(String fmCategory) {
		this.fmCategory = fmCategory;
	}

	@Override
	public String toString() {
		return description;
	}
}
