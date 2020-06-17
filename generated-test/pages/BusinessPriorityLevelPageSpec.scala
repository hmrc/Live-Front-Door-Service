package pages

import models.BusinessPriorityLevel
import pages.behaviours.PageBehaviours

class BusinessPriorityLevelSpec extends PageBehaviours {

  "BusinessPriorityLevelPage" must {

    beRetrievable[BusinessPriorityLevel](BusinessPriorityLevelPage)

    beSettable[BusinessPriorityLevel](BusinessPriorityLevelPage)

    beRemovable[BusinessPriorityLevel](BusinessPriorityLevelPage)
  }
}
