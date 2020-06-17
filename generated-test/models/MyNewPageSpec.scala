package models

import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Gen
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.{MustMatchers, OptionValues, WordSpec}
import play.api.libs.json.{JsError, JsString, Json}

class MyNewPageSpec extends WordSpec with MustMatchers with ScalaCheckPropertyChecks with OptionValues {

  "MyNewPage" must {

    "deserialise valid values" in {

      val gen = Gen.oneOf(MyNewPage.values.toSeq)

      forAll(gen) {
        myNewPage =>

          JsString(myNewPage.toString).validate[MyNewPage].asOpt.value mustEqual myNewPage
      }
    }

    "fail to deserialise invalid values" in {

      val gen = arbitrary[String] suchThat (!MyNewPage.values.map(_.toString).contains(_))

      forAll(gen) {
        invalidValue =>

          JsString(invalidValue).validate[MyNewPage] mustEqual JsError("error.invalid")
      }
    }

    "serialise" in {

      val gen = Gen.oneOf(MyNewPage.values.toSeq)

      forAll(gen) {
        myNewPage =>

          Json.toJson(myNewPage) mustEqual JsString(myNewPage.toString)
      }
    }
  }
}
