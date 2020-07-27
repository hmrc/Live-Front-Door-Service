package views

import views.behaviours.ViewBehaviours
import views.html.LiveServiceTeamContactsView

class LiveServiceTeamContactsViewSpec extends ViewBehaviours {

  "LiveServiceTeamContacts view" must {

    val view = viewFor[LiveServiceTeamContactsView](Some(emptyUserAnswers))

    val applyView = view.apply()(fakeRequest, messages)

    behave like normalPage(applyView, "liveServiceTeamContacts")

    behave like pageWithBackLink(applyView)
  }
}
