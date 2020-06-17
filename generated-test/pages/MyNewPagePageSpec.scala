package pages

import models.MyNewPage
import pages.behaviours.PageBehaviours

class MyNewPageSpec extends PageBehaviours {

  "MyNewPagePage" must {

    beRetrievable[MyNewPage](MyNewPagePage)

    beSettable[MyNewPage](MyNewPagePage)

    beRemovable[MyNewPage](MyNewPagePage)
  }
}
