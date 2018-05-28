<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
    <jsp:include page="/baselayout/head.jsp" />
    <title>イベント新規登録ページ</title>
</head>

<body class="color-lightgreen">
    <jsp:include page="/baselayout/header.jsp" />


    <br><br><br>
    <h1 class="text-center">イベント新規登録</h1>
    <br><br>

    <div class="container width1">
        <form action="MasterEventRegister" method="post" enctype="multipart/form-data">
            <div class="row">
                <span class="col  width50">

                    <button class="btn col btncolor1" type="submit" name="stop">
                            取りやめる
                        </button>
                </span>
                <span class="col  width50"></span>
                <span class="col  width50">

                    <button class="btn  col btncolor1" type="submit" name="Regester">
                            新規登録する
                    </button>

                </span>

            </div>

            <br>

            <div class="card grey lighten-5 ">
                <h3 class="text-center">イベント表新規登録フォーム</h3>
                <br> 写真img
                <p>
                    <input type="file" name="upLoadFileName" >
                </p>
				トップtitle
                <div class="form-group">
                    <textarea class="form-control" rows="3" name="title" required></textarea>
                </div>
                <br> 内容summary
                <div class="form-group">
                    <textarea class="form-control" rows="8" name="summary" required></textarea>
                </div>
                <br> 募集分類event_category
                <div class="form-group">
                    <textarea class="form-control" rows="1" name="event_category" required></textarea>
                </div>
                <br> スケジュールschedule
                <div class="form-group">
                    <textarea class="form-control" rows="1" name="schedule" required></textarea>
                </div>
                <br> 地域local_region
                <div class="form-group">
                    <textarea class="form-control" rows="1" name="local_region" required></textarea>
                </div>
                <br> 参加費用fees
                <div class="row">
	                <div class="form-group  col">
	                    <input type="number" class="form-control" name="fees" required><%-- class="col"の修飾する位置に注意 --%>
	                </div>
	                 <div class="col">
	                 	円
	                </div>
	                <div class="col">

	                </div>
                </div>
                <br> 交通access
                <div class="form-group" >
                    <textarea class="form-control" rows="3" name="access" required></textarea>
                </div>
                <br> 参加資格qualification
                <div class="form-group">
                    <textarea class="form-control" rows="7" name="qualification" required></textarea>
                </div>
                <br> 講演者presenter
                <div class="form-group">
                    <textarea class="form-control" rows="1" name="presenter" required></textarea>
                </div>
                <br> 主催organizer
                <div class="form-group">
                    <textarea class="form-control" rows="1" name="organizer" required></textarea>
                </div>
            </div>

            <br>



            <br>
            <br>
            <div class="row">
                <span class="col  width50">

                    <button class="btn col btncolor1" type="submit" name="stop">
                        取りやめる
                    </button>
                </span>
                <span class="col  width50"></span>
                <span class="col  width50">

                    <button class="btn  col btncolor1" type="submit" name="action">
                        新規登録する
                    </button>

                </span>

            </div>
            <br>
            <br>
            <h1 class="text-center">概要表サンプル</h1>
            <br>
            <br>
            <div class="card grey lighten-5 width1">
                <div class="class-table width2 border-radius ">
                    <div class="class-table-row ">
                        <div class="class-table-cell class-table-cell-left2">
                            <image src="../../forecimage/LIKEITimagesmall.png" />
                        </div>
                        <div class="class-table-cell class-table-cell-right1">
                            <h5>LIKEIT 完全無料で即戦力エンジニアとして今すぐIT企業に正社員就職</h5>
                        </div>
                    </div>
                    <div class="class-table-row">
                        <div class="class-table-cell class-table-cell-left1">内容</div>
                        <div class="class-table-cell class-table-cell-right1">有名Webサービス運営企業で導入されたカリキュラムと マンツーマン指導で即戦力エンジニアになる 最高のカリキュラムを使って480時間現役エンジニアとマンツーマンで学ぶ短期集中プログラム。株式会社DMM.comラボ、株式会社ぐるなび、株式会社NTTコム オンライン・マーケティング・ソリューション株式会社といった有名企業も含め、毎年400名以上の新人エンジニアを育成してきたノウハウを詰め込んだ実践カリキュラムをオンラインテキスト化。 このカリキュラムに沿って自分のペースで課題を解き、悩んだらすぐにメンターに聞いて納得するまで教えてもらえる個別学習×マンツーマン指導だから、3ヶ月間の学習効率を圧倒的に高めることができます。スクールに来れない日は、チャットで無制限の質問サポートも。
                        </div>
                    </div>
                    <div class="class-table-row">
                        <div class=" class-table-cell class-table-cell-left1">募集分類</div>
                        <div class="class-table-cell class-table-cell-right1">研修</div>
                    </div>
                    <div class="class-table-row ">
                        <div class="class-table-cell class-table-cell-left1">日程</div>
                        <div class="class-table-cell class-table-cell-right1">詳細ページへ</div>
                    </div>
                    <div class="class-table-row">
                        <div class="class-table-cell class-table-cell-left1">地域</div>
                        <div class="class-table-cell class-table-cell-right1">
                            日本 関東地域
                        </div>
                    </div>
                    <div class="class-table-row">
                        <div class="class-table-cell class-table-cell-left1">参加費用</div>
                        <div class="class-table-cell class-table-cell-right1">
                            0円
                        </div>
                    </div>
                    <div class="class-table-row">
                        <div class="class-table-cell class-table-cell-left1">交通</div>
                        <div class="class-table-cell class-table-cell-right1">
                            〒103-0015 東京都中央区日本橋箱崎町27-2 渡菊第3ビル 6階 東京メトロ半蔵門線「水天宮前駅」より徒歩３分 東京メトロ日比谷線・東西線「茅場町駅」より徒歩10分
                        </div>
                    </div>
                    <div class="class-table-row">
                        <div class="class-table-cell class-table-cell-left1">参加資格</div>
                        <div class="class-table-cell class-table-cell-right1">
                            選考などは実施しておりません。以下の5つの条件を満たしている方であればどなたでもご参加いただくことができます。<br>
                            <br> 1．東京、神奈川、千葉、埼玉にお住まいの方
                            <br> 2．ご年齢が18歳以上、30歳未満の方
                            <br> 3．週3日以上、スクールに通学して学習・就職活動可能な方
                            <br> 4．日本国籍をお持ちの方
                            <br> 5．以下のいずれかに当てはまる方
                            <br> ・アルバイト・フリーターの方
                            <br> ・現在離職中、または3ヶ月以内に現職を退職予定の会社員の方
                            <br> ・大学/専門学校に在籍している、2019年度就活生の方
                            <br> ・現在無職で、正社員の仕事をお探しの方
                            <br>
                        </div>
                    </div>
                    <div class="class-table-row">
                        <div class="class-table-cell class-table-cell-left1">主催</div>
                        <div class="class-table-cell class-table-cell-right1">
                            LIKEIT
                        </div>
                    </div>
                    <div class="class-table-row">
                        <div class=" class-table-cell class-table-cell-left1"></div>
                        <div class="class-table-cell class-table-cell-right1">
                            <div class="a">
                                <p class="align-center ">
                                    <button class="btn col btncolor1 " type="submit" name="action">
                                        <span class="a">カートに入れる</span>
                                    </button>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <br>
            <h1 class="text-center">詳細表サンプル</h1>
            <br>
            <br>
            <div class="card grey lighten-5 width1">
                <div class="class-table width2 border-radius ">
                    <div class="class-table-row ">
                        <div class="class-table-cell class-table-cell-left2">
                            <image src="../../forecimage/LIKEITimagesmall.png" />
                        </div>
                        <div class="class-table-cell class-table-cell-right1">
                            <h5>LIKEIT 完全無料で即戦力エンジニアとして今すぐIT企業に正社員就職</h5>
                        </div>
                    </div>
                    <div class="class-table-row">
                        <div class="class-table-cell class-table-cell-left1">内容</div>
                        <div class="class-table-cell class-table-cell-right1">有名Webサービス運営企業で導入されたカリキュラムと
                            マンツーマン指導で即戦力エンジニアになる
                            最高のカリキュラムを使って480時間現役エンジニアとマンツーマンで学ぶ短期集中プログラム。株式会社DMM.comラボ、株式会社ぐるなび、株式会社NTTコム オンライン・マーケティング・ソリューション株式会社といった有名企業も含め、毎年400名以上の新人エンジニアを育成してきたノウハウを詰め込んだ実践カリキュラムをオンラインテキスト化。

                            このカリキュラムに沿って自分のペースで課題を解き、悩んだらすぐにメンターに聞いて納得するまで教えてもらえる個別学習×マンツーマン指導だから、3ヶ月間の学習効率を圧倒的に高めることができます。スクールに来れない日は、チャットで無制限の質問サポートも。
                        </div>
                    </div>
                    <div class="class-table-row">
                        <div class=" class-table-cell class-table-cell-left1">募集分類</div>
                        <div class="class-table-cell class-table-cell-right1">研修</div>
                    </div>
                    <div class="class-table-row ">
                        <div class="class-table-cell class-table-cell-left1">日程</div>
                        <div class="class-table-cell class-table-cell-right1">詳細ページへ</div>
                    </div>
                    <div class="class-table-row">
                        <div class="class-table-cell class-table-cell-left1">地域</div>
                        <div class="class-table-cell class-table-cell-right1">
                            日本 関東地域
                        </div>
                    </div>
                    <div class="class-table-row">
                        <div class="class-table-cell class-table-cell-left1">参加費用</div>
                        <div class="class-table-cell class-table-cell-right1">
                            0円
                        </div>
                    </div>
                    <div class="class-table-row">
                        <div class="class-table-cell class-table-cell-left1">参加資格</div>
                        <div class="class-table-cell class-table-cell-right1">
                            選考などは実施しておりません。以下の5つの条件を満たしている方であればどなたでもご参加いただくことができます。<br>
                            <br> 1．東京、神奈川、千葉、埼玉にお住まいの方
                            <br> 2．ご年齢が18歳以上、30歳未満の方
                            <br> 3．週3日以上、スクールに通学して学習・就職活動可能な方
                            <br> 4．日本国籍をお持ちの方
                            <br> 5．以下のいずれかに当てはまる方
                            <br> ・アルバイト・フリーターの方
                            <br> ・現在離職中、または3ヶ月以内に現職を退職予定の会社員の方
                            <br> ・大学/専門学校に在籍している、2019年度就活生の方
                            <br> ・現在無職で、正社員の仕事をお探しの方
                            <br>
                        </div>
                    </div>
                    <div class="class-table-row">
                        <div class="class-table-cell class-table-cell-left1">主催</div>
                        <div class="class-table-cell class-table-cell-right1">
                            LIKEIT
                        </div>
                    </div>
                    <div class="class-table-row">
                        <div class=" class-table-cell class-table-cell-left1"></div>
                        <div class="class-table-cell class-table-cell-right1">
                            <div class="a">
                                <p class="align-center ">
                                    <button class="btn col btncolor1 " type="submit" name="action">
                                        <span class="a">カートに入れる</span>
                                    </button>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </form>
    </div>

    <br>
    <br>
    <br>
    <br>
    <br>
    <br>


    <footer class="footer1">testテスト</footer>
</body>

</html>