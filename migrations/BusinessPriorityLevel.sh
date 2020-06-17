#!/bin/bash

echo ""
echo "Applying migration BusinessPriorityLevel"

echo "Adding routes to conf/app.routes"

echo "" >> ../conf/app.routes
echo "GET        /businessPriorityLevel                        controllers.BusinessPriorityLevelController.onPageLoad(mode: Mode = NormalMode)" >> ../conf/app.routes
echo "POST       /businessPriorityLevel                        controllers.BusinessPriorityLevelController.onSubmit(mode: Mode = NormalMode)" >> ../conf/app.routes

echo "GET        /changeBusinessPriorityLevel                  controllers.BusinessPriorityLevelController.onPageLoad(mode: Mode = CheckMode)" >> ../conf/app.routes
echo "POST       /changeBusinessPriorityLevel                  controllers.BusinessPriorityLevelController.onSubmit(mode: Mode = CheckMode)" >> ../conf/app.routes

echo "Adding messages to conf.messages"
echo "" >> ../conf/messages.en
echo "businessPriorityLevel.title = Low" >> ../conf/messages.en
echo "businessPriorityLevel.heading = Low" >> ../conf/messages.en
echo "businessPriorityLevel.medium = High" >> ../conf/messages.en
echo "businessPriorityLevel.option2 = Option 2" >> ../conf/messages.en
echo "businessPriorityLevel.checkYourAnswersLabel = Low" >> ../conf/messages.en
echo "businessPriorityLevel.error.required = Select businessPriorityLevel" >> ../conf/messages.en

echo "Adding to UserAnswersEntryGenerators"
awk '/trait UserAnswersEntryGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryBusinessPriorityLevelUserAnswersEntry: Arbitrary[(BusinessPriorityLevelPage.type, JsValue)] =";\
    print "    Arbitrary {";\
    print "      for {";\
    print "        page  <- arbitrary[BusinessPriorityLevelPage.type]";\
    print "        value <- arbitrary[BusinessPriorityLevel].map(Json.toJson(_))";\
    print "      } yield (page, value)";\
    print "    }";\
    next }1' ../test/generators/UserAnswersEntryGenerators.scala > tmp && mv tmp ../test/generators/UserAnswersEntryGenerators.scala

echo "Adding to PageGenerators"
awk '/trait PageGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryBusinessPriorityLevelPage: Arbitrary[BusinessPriorityLevelPage.type] =";\
    print "    Arbitrary(BusinessPriorityLevelPage)";\
    next }1' ../test/generators/PageGenerators.scala > tmp && mv tmp ../test/generators/PageGenerators.scala

echo "Adding to ModelGenerators"
awk '/trait ModelGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryBusinessPriorityLevel: Arbitrary[BusinessPriorityLevel] =";\
    print "    Arbitrary {";\
    print "      Gen.oneOf(BusinessPriorityLevel.values.toSeq)";\
    print "    }";\
    next }1' ../test/generators/ModelGenerators.scala > tmp && mv tmp ../test/generators/ModelGenerators.scala

echo "Adding to UserAnswersGenerator"
awk '/val generators/ {\
    print;\
    print "    arbitrary[(BusinessPriorityLevelPage.type, JsValue)] ::";\
    next }1' ../test/generators/UserAnswersGenerator.scala > tmp && mv tmp ../test/generators/UserAnswersGenerator.scala

echo "Adding helper method to CheckYourAnswersHelper"
awk '/class/ {\
     print;\
     print "";\
     print "  def businessPriorityLevel: Option[AnswerRow] = userAnswers.get(BusinessPriorityLevelPage) map {";\
     print "    x =>";\
     print "      AnswerRow(";\
     print "        HtmlFormat.escape(messages(\"businessPriorityLevel.checkYourAnswersLabel\")),";\
     print "        HtmlFormat.escape(messages(s\"businessPriorityLevel.$x\")),";\
     print "        routes.BusinessPriorityLevelController.onPageLoad(CheckMode).url";\
     print "      )"
     print "  }";\
     next }1' ../app/utils/CheckYourAnswersHelper.scala > tmp && mv tmp ../app/utils/CheckYourAnswersHelper.scala

echo "Migration BusinessPriorityLevel completed"
