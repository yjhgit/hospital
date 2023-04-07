/*
 Navicat Premium Data Transfer

 Source Server         : 124.71.217.106-ya
 Source Server Type    : MySQL
 Source Server Version : 50740
 Source Host           : 124.71.217.106:3306
 Source Schema         : ya

 Target Server Type    : MySQL
 Target Server Version : 50740
 File Encoding         : 65001

 Date: 07/04/2023 15:43:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '文章标题',
  `article_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '文章封面',
  `article_text` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '文章内容',
  `add_time` datetime NOT NULL COMMENT '添加事件',
  `article_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '文章作者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_timestamp ON UPDATE CURRENT_timestamp COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (6, '健身人都在吃的这种主食，竟然还能稳定你的血糖和血脂！', '/articleImg/3946c5ec-798f-4cda-93e3-8c6d127a5ec4.jpg', '很多健身人士对于藜麦都不陌生，但是普通人却鲜少了解它\n其实藜麦是赫赫有名的“素食之王”，不仅营养全面，富含多种维生素，而且还有降脂功效！\n什么是藜麦？\n出生：7000多年前的南美洲安第斯山区，是印加土著居民的主要传统食物。营养价值：低热量、无麸质、富含多种蛋白质，其中35%是人体必须氨基酸，同时拥有多种维生素、锰镁铁锌钙等矿物质、膳食纤维。无所不能就是它！成名于：上世纪80年代，NASA（美国国家航空航天局）将藜麦列为人类未来移民外太空空间的理想的“太空粮食”，2013年联合国大会宣布当年为“国际藜麦年”。\n适宜人群：一家大小、男女老幼、糖尿病患者也可以吃哦。', '2023-03-21 12:05:23', '杏林堂中医馆', '2023-03-21 20:35:22');
INSERT INTO `article` VALUES (7, '注意：你一直认为健康的“盘腿坐”，可能并不适合你！做多甚至“毁膝”', '/articleImg/ce9f5663-614f-4ed7-bcfd-c5a1e23e6fa7.png', '关注养生、锻炼的朋友们一定知道盘腿坐在瑜伽、气功、武术里是一种对身体非常有利的坐姿。盘腿不会像下肢自然下垂的坐姿，导致下肢水肿等问题:可以减少并放慢下半身的血液循环，也就是相当于增加了上半身，尤其是胸腔和脑部的血液循环，对改善肺功能非常有效。\n但是，并不是每个人都适合盘腿坐，有的人盘腿后会下肢疼痛、膝盖不适等，这到底是为何?\n中医认为，盘腿坐对身体有何益处?\n盘腿坐有利于拉伸筋骨，疏通经络，促进体内的气血循环加快\n盘腿坐时腿部的穴脉会被压着，导致血液输送变慢，大部分血液集中在上半身处，使得内脏血量更加充足，大脑供血也会更加充分，人的注意力更加集中，有利于记忆力的提高.\n盘腿坐还有利于肾气的补充，使得肾气更加充足，促进机体的新陈代谢，还能避免誉椎病的发生。\n如果您患有膝关节骨性关节炎，就非常不建议练习盘腿坐，因为这样不但不能提高膝关节周围肌肉和韧带的稳定性，还可能加重膝关节不稳，导致关节软骨的损伤。\n由于盘着坐的缘故，膝关节内侧受到挤压、外侧受到牵拉，内侧韧带的长时间过度受压就会导致膝关节疼痛，甚至会出现膝关节变形。\n正确的盘腿坐应该注意什么?\n时间：建议大家每次盘腿坐的时间不要超过 15 分钟，而且需要考虑自身耐受程度和个体差异，循序渐进，腿部出现疼痛或者麻痹的症状时，要适时松开双腿，辅以按摩或者走动。\n拍打：可以通过拍打手法以疏通经络，达到防病治病的目的手法:空心掌使用一定力度反复拍打膝关节的前侧、内外侧和后侧膝关节前侧拍打是疏通脾经和胃经，外侧是疏通胆经，内侧是疏通肝经和肾经，后侧是疏通膀胱经。', '2023-03-21 12:13:35', '杏林堂中医馆', '2023-03-21 20:36:31');
INSERT INTO `article` VALUES (8, '睡醒后手麻的原因有很多，该怎么办? 医生告诉你答案', '/articleImg/67ab7db1-d5c6-4a28-9609-576b63bc392d.jpg', '晚上睡觉时，若手臂被压在了身体下或者是被压在了头下，等到起床后你会感觉手指会异常的发麻，这种情况是较为常见的\n很多人都曾经经历过，晨起后手麻可能是睡姿不当引起的，这并不需要担心过几分钟就可以得到缓解，倘若你睡觉时睡姿并没有问题，胳膊和手并没有被压到早晨起床后却经常手麻，出现这种情况就要警惕了，可能是疾病的征兆\n那么睡觉手麻是什么原因呢？可能是哪些疾病引起的？如何预防呢？\n今天我们就来说说这些问题吧~\n睡觉手麻的原因\n1姿势不对：睡觉姿势不对，比如将手压在身体下面，时间长了引起血液不循环，导致手麻。\n2枕头问题：枕头垫太高也会导致血液不循环，导致手指发麻。\n3腕管综合征：手腕正中间，有个叫“腕管”的结构，腕管周围有肌腱和神经，倘若你经常干活，手腕需要常常的活动，比如你是厨师，需要经常颠勺，或者你是家庭主妇，经常干家务，会用到手腕等，此处的压力会变大，神经会受到压迫，这也会使你出现手麻的情况。倘若你只是手麻，并且手腕常常不舒服，身体并无其它异样，说明你手麻可能是腕管出问题造成的。\n预防手麻的建议：生活中，我们应当注意避免长时间低头，避免颈部长时间保持一个姿势，多活动颈部，睡觉时枕头不要过高、过硬。\n有空时，做下列动作可以预防手麻现象：五指张开垂直压桌面4-5秒；用力握拳4-5秒，然后将五指张开，这两种动作可以重复做几次。\n总之，如果经常感觉手麻的话，我们可不能忽视，要及时去医院，找到病因，必要时需要借助颈椎片、测血糖等辅助检查，以便针对性治疗。', '2023-03-22 08:00:13', '杏林堂中医馆', '2023-03-22 16:00:13');
INSERT INTO `article` VALUES (9, '注意！这些食物可能会延长孩子鼻炎及腺样体肥大的病程！', '/articleImg/a56c73ea-6c22-449d-b80a-501133693d3a.jpg', '鼻炎及腺样体肥大和孩子的饮食有比较大的相关性。临床上经常能见到由于“管不住嘴”，病情反反复复的情况发生。为了减少病情的反复、加速患者的好转，郭医生在治疗这类疾病上很重视孩子的饮食忌口。\n为了方便记忆和理解，郭医生将会延长病程的饮食分为3个等级：尽量少吃的食物、尽量不吃的食物和绝对不能吃的食物。\n尽量少吃：海鲜、巧克力、红枣（除非其他中药搭配）、添加剂多的零食（饼干、果冻等）、玉米、糙米、死面类的饼、寒凉水果（西瓜、雪梨、火龙果等）、湿热水果（芒果、荔枝等）。\n尽量不吃：非当季水果、鸡肉、鸡蛋、鸡汤、鹌鹑蛋、羊肉等。\n绝对不吃：冰淇淋、冷饮等冷食冷饮。', '2023-03-22 08:05:33', '杏林堂中医馆', '2023-03-22 16:05:33');
INSERT INTO `article` VALUES (10, '体检查出结节怎么办？一篇文章帮你搞清楚！', '/articleImg/1d0fdab3-1f8f-478f-bba0-9b2c0fa77540.jpg', '今天何医生要给大家带来有关结节的概念，随着人们物质水平的不断提升，相应的健康体检也逐渐成为了每一位公民日常生活中的一部分，而“结节”这一概念也随之进入到人们的视野当中。\n所谓结节，就是生长在各个器官内不同性质的实性病变，多出现在甲状腺、乳腺、肝脏、胰腺、肾脏等实质性器官的实质内或表面。\n出现结节并不可怕，关键是要明确结节的性质，若是结节表现为良性，没有恶变倾向，对周围组织器官没有出现压迫症状，便可以定期观察，口服中药保守治疗，而非采用手术治疗而动气耗血。中医在治疗结节方面有其独到之处，下面何医生将从中医的角度向大家科普结节的来源。\n中医认为结节属于“积聚”、“癥瘕”、“岩”等范畴，《金匮要略》中的五脏风寒积聚篇则深刻揭示了它的性质，即五脏是它的本体，风寒是诱因，积聚是结果。《灵枢》篇有道：“肠胃之络伤，则血溢于肠外，肠外有寒，汁沫与血相抟，则并合凝聚不得散而积成矣。”\n现代人因久居空调、且嗜食辛辣生冷油腻等物，导致自身脾胃功能受到破坏，加之寒邪在里，阴积而成形，并得阴中之阳化而不断形生，甚则窃人之真阳助长，盗人之真阴化形日久之后便易形成结节之类的有形之物。\n总而言之，病理产物的产生离不开自身平日不良的生活习惯，导致正气的亏耗使得邪气有机可乘。但是，常言道：“解铃还须系铃人”，既然源于自身正气不足导致邪气来犯，那我们也可通过中药增强自己的正气来保卫我们自身。\n所谓中医的正气，通俗地来说可以理解为我们自身的免疫细胞，免疫细胞的强弱依赖于我们细胞的外环境是否良好，而中医药的强势之处在于可以通过服用中药，改善我们细胞的内外环境，从而使得免疫细胞重新绽放活力，消灭结节乃至肿瘤！', '2023-03-22 08:06:58', '杏林堂中医馆', '2023-03-22 16:06:58');
INSERT INTO `article` VALUES (11, '腰椎间盘突出，推拿能“按”回去吗？来告诉你真相', '/articleImg/569ca09d-fbdf-4b9c-9719-03281f05b9cc.jpg', '在门诊的时候，有些腰椎间盘突出的患者会问到，医院的骨科医生说只能做手术才能治好，但我实在不想走到手术这一步\n听说有的医生可以通过正骨按摩的方法，将突出的椎间盘给你按回去，这种说法可靠吗？推拿真的能将我们的椎间盘推回去吗？\n答案当然是不行！这种说法是大错特错！\n首先，椎间盘突出的位置很深，且居于躯干的核心部位，椎间盘突出的地方位于脊柱的中间，在外表是根本也摸不到这个突出的椎间盘。所以按摩不管力量多大采取什么样的方式，什么样的手法都是不能透过肌肉到椎间盘的，按都按不到\n谈何能把椎间盘突出的地方按回去？但有不少腰椎间盘突出的患者发现，推拿后确实感觉舒服了不少\n这又是怎么回事呢？首先我们知道的是合适的推拿是可缓解腰椎间盘突出症，因为推拿也是腰椎间盘突出症的治疗方式之一\n很多人认为所有腰椎间盘突出都需要手术，可事实上只有10%~20%的患者才需要手术治疗，绝大多数腰椎间盘突出的患者，经过康复治疗可达到临床症状的缓解或消失，而推拿属于康复医学中传统康复治疗的技术之一。虽然推拿无法复位突出的椎间盘，但可以解除腰椎间盘局部的肌肉痉挛\n松解粘连、纠正关节错位，增宽关节间隙，从而可以减轻对椎间盘的压力，减缓神经血管被压迫的机械力，就能减轻腰腿痛的症状，所以，很多人在做完推拿后，各种不适症状能得到很好的缓解。所以，将突出的椎间盘给按回去的说法，完全是一种误导，这是一种想当然的事情，真正是不可能做到的，大家一定千万要记住，因此若是你确诊为腰椎间盘突出，又不能确定是否适合推拿，一定要咨询医生，并且找专业的康复科或骨科医生进行推拿治疗。不过要注意的是，不是所有的腰椎间盘突出患者都适合推拿，并且推拿也不是随便按按就行，力度、手法上均有专业的讲究，若是随便乱推拿，很有可能会压迫到脊髓及神经根，加重原有的症状甚至引起瘫痪。', '2023-03-22 08:11:47', '杏林堂中医馆', '2023-03-22 16:11:46');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `article_id` int(11) NOT NULL COMMENT '文章id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES (1, 3, 1);
INSERT INTO `collect` VALUES (2, 4, 6);
INSERT INTO `collect` VALUES (8, 5, 5);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NULL DEFAULT NULL COMMENT '上级id',
  `department_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '科室名称',
  `department_des` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '科室描述',
  `department_sort` int(10) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, NULL, '内科', '内科描述', 1);
INSERT INTO `department` VALUES (2, 1, '呼吸内科', '呼吸内科描述', 1);
INSERT INTO `department` VALUES (3, 1, '消化内科', '消化内科描述', 2);
INSERT INTO `department` VALUES (4, 1, '神经内科', '神经内科描述', 3);
INSERT INTO `department` VALUES (5, NULL, '儿科', '儿科描述', 2);
INSERT INTO `department` VALUES (6, 5, '新生儿科', '新生儿科描述', 1);
INSERT INTO `department` VALUES (7, 5, '儿童营养保健科', '儿童营养保健科描述', 2);
INSERT INTO `department` VALUES (8, NULL, '保健科', '保健科描述', 3);

-- ----------------------------
-- Table structure for drugs
-- ----------------------------
DROP TABLE IF EXISTS `drugs`;
CREATE TABLE `drugs`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '药品名称',
  `drugs_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '药材封面',
  `synopsis` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '药材简介',
  `drugs_info` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '药材详情',
  `add_time` datetime NOT NULL DEFAULT CURRENT_timestamp ON UPDATE CURRENT_timestamp COMMENT '录入时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drugs
-- ----------------------------
INSERT INTO `drugs` VALUES (1, '人参', '/drugsImg/488dd017-f71c-40ec-8902-222e68195028.jpg', '中药材人参是一种补气药，为五加科植物人参的千燥根和根茎。', '人参味甘、微苦，微温，归脾、肺、心、肾经\n人参甘补微温，微苦不泄，药力强大，为补气强身之要药。既善大补元气，治气虚欲脱，又善补脾肺之气治脾肺气虚诸证，还能补气而生津、安神、益智，治津伤口渴、消渴、心神不安、惊悸健忘等.主要含人参二醇类、人参三醇类、齐墩果酸类多种人参皂昔，尚含有人参多糖、多肤类化合物、酷类化合物、倍半枯醇类化合物、炔类化合物、氨基酸、有机酸、生物碱、维生素、酶类、黄酮类、挥发油、微量元素等成分，具有大补元气，复脉固脱，补脾益肺，生津养血，安神益智的功效。\n入药部位\n人参的入药部位:人参为五加科植物人参Panax ginseng C.A.Mey的干燥根和根茎,人参以根及根茎入药。产于吉林者称“吉林人参”、“吉林参”。野生者名“山参”，栽培者俗称“园参”。播种在山林野生状态下自然生长的称“林下山参”，习称“籽海”。多于秋季采挖，洗净经晒千或烘干。人参入药部位的性状特点:\n润透，切薄片，干燥，或用时粉碎、捣碎。本品有特异香气，味微苦而甘。以切面色淡黄白，点状树脂道多者为佳。生用。此外，人参叶也可入药。功效作用：人参用于体虚欲脱，肢冷脉微，脾虚食少，肺虚喘咳，津伤口渴，内热消渴，气血亏虚，久病虚赢，惊悸失眠，阳痿宫冷。气虚欲脱证，本品善大补元气，能复脉固脱，适宜于因大汗、大吐、大泻、大失血或大病、久病所致元气虚极欲脱，气短神疲，脉微欲绝的重危证候，为补气固脱之要药。脾气虚证。本品善补脾益气，为补脾气之要药。适宜于脾气虚，倦怠乏力，食少便清者。肺气虚证\n本品能补益肺气，亦为补肺气之要药，适宜于肺气虚，气短喘促，懒言声微等.\n津伤口渴及内热消渴本品既能益气，又生津止渴，适宜于热病气津两伤，身热口渴、汗多、脉虚大无力。\n心神不宁，失眠多梦，惊悸健忘\n本品能补益心气，安神益智，适宜于心气虚之心神不宁、失眠多梦、惊悸健忘，可单用，或与补心气、通心阳药物同用。\n此外，对气不摄血的出血证及阳痿，本品能益气以摄血或益气以助阳;还常与解表药、攻下药等祛邪药配伍，用于气虚外感或里实热结而气血虚弱等邪实正虚之证。', '2023-03-23 15:29:19');
INSERT INTO `drugs` VALUES (5, '黄芩', '/drugsImg/afa53733-e5e5-40ac-a5c5-6bde2945014d.jpg', '中药材黄芬是一味清热燥湿药，为唇形科植物黄苓的干燥根。', '黄苓药性苦，寒。归肺、胆、脾、大肠、小肠经。黄苦寒清泄而燥，主入肺与大肠经，兼入胆、脾、胃经。既清热泻火而凉血止血、安胎、解热毒，又燥湿、除湿度而解湿热毒。为治湿热火毒之要药，广泛用于湿热火毒之病症。与黄连相比，其清热燥湿力较弱，作用偏于上焦肺及大肠，善清上焦湿热，除肺与大肠之火。\n本品含有黄苓昔、黄苓素(黄昔元) 、汉黄素、汉黄苓昔、黄新素等黄酮类成分。此外，还含有苯乙酮、棕榈酸、油酸等挥发油成分、B-谷醇、黄苓酶等成分，具有清热燥湿，泻火解毒，止血，安胎的功能。\n功效作用\n黄苓用于湿温、暑湿，胸闷呕恶，湿热痞满，泻痴，黄痘，肺热咳嗽，高热烦渴，血热吐妞，痛肿动不安。\n湿热证\n。治湿温、暑温，胸闷呕恶，湿热痞满，常与滑石、豆、通草等同用:\n。治湿热泻痴，常与葛根、黄连等同用:\n。治湿热黄痘，常与茵陈、栀子等同用\n肺热咳嗽：\n。治邪热璀肺之咳嗽，可单用:\n治痰热塞肺之咳嗽痰黄稠黏者，常与知母、浙贝母、桔梗等同用\n疮痛肿毒\n可与黄连、连翘、甘草等同用。\n血热出血：\n治火毒炽盛，迫血妄行所致的吐血、妞血等出血，可单用黄苓炭，或与大黄、黄连同用\n胎动不安：\n治妊娠胎中有火热不安者，可与知母、白芍、白术等同用。', '2023-03-23 15:32:58');
INSERT INTO `drugs` VALUES (6, '当归', '/drugsImg/b3c8b98d-18bc-4e8f-a05a-8dd8d3da414f.jpg', '中药材当归是一种补血药，为伞形科植物当归的干燥根。', '当归味甘、辛，温，归肝、心、脾经。\n当归甘能补润，辛温行散，主入肝、心经，兼入脾经。善补血活血、调经止痛、润肠通便，并能散寒，凡血虚、血瘀有寒之证均宜，兼肠燥便秘者尤佳，既为妇科调经之要药，又为内科补血之佳品，还为外科、伤科\n消肿疗伤所常用。\n主要含蔓本内、当归酮、香荆芥酚、正丁烯味内酶、马鞭草烯酮，黄樟醚等挥发油，阿魏酸、香草酸、烟酸、琥珀酸等有机酸成分，并含有当归多糖、氨基酸、维生素A等成分。\n功效作用：当归用于血虚萎黄，眩晕心悸，月经不调，经闭痛经，虚寒腹痛，风湿痹痛，跌扑损伤，痈疽疮疡，肠燥便秘。\n。生当归质润，长于补血，调经，润肠通便，常用于血虚证、血虚便秘、痛疽疮疡等.\n。酒当归功善活血调经，常用于血瘀经闭、痛经，风湿痹痛，跌扑损伤等。\n。又传统认为，当归身偏于补血，当归头偏于止血，当归尾偏于活血，全当归偏于和血(补血活血)。\n血虚诸证\n当归有良好的补血功效，适宜血虚诸证，常与熟地黄、白芍、川营同用。\n月经不调，闭经，痛经\n本品既能补血活血，又能调经止痛，为妇科要药，尤宜于血虚、血滞、气血不和，冲任失调之月经不调，闭经，痛经\n虚寒腹痛，风湿痹痛，跌扑损伤\n本品既善活血止痛，温散寒凝，又能补血，适宜于血虚、血瘀兼寒凝所致诸痛.痈疽疮疡\n本品能补血活血，托毒消肿，又为外科常用药，适宜于痛痘疮疡。肠燥便秘：\n本品能润肠通便，适宜于肠燥便秘，因其长于补血，尤宜于年老体弱、妇女产后之血虚肠燥便秘，常与养血润肠药同用。', '2023-03-23 16:15:55');
INSERT INTO `drugs` VALUES (7, '茯苓', '/drugsImg/8fa60436-2d88-424d-8106-99c1482addab.jpg', '获夸是一种利水渗湿药，为多孔菌科真菌获苓的干燥菌核。', '获苓药性甘、淡，平。归心、肺、脾、肾经。\n获苓甘淡渗利兼补，性平不偏，既入脾、肾经，善渗湿利水而消水饮，健脾而促进水湿运化;又入心经，善宁心而安神，治水气凌心者为宜。凡,水湿、停饮，无论寒热或兼否脾虚皆宜，脾虚水肿或湿盛者尤佳。\n本品主要含多糖、三枯类成分、笛醇类成分，还含蛋白质、脂肪、卵磷脂、腺凛岭等成分。\n功效作用：\n获苓用于小便不利，水肿胀满，痰饮咳逆，呕吐，脾虚食少，泄泻，心悸不安，失眠健忘，遗精白浊。\n水肿:\n治水湿内停之水肿、小便不利者，常与猪苓、泽泻、白术等同用\n治脾肾阳虚之水肿，常与附子、白术等同用;\n治水热互结，阴虚小便不利、水肿者，常与滑石、阿胶、泽泻等同用.\n脾虚泄泻:\n治脾虚湿盛之食少倦意、便泄泻，常与白术、山药、慧故仁等同用。痰饮证:\n治脾失健运，湿聚成痰所致的咳嗽痰多、色白易咯者，常与半夏、陈皮等同用;若治中阳不足，饮停胸胁，症见胸胁胀满、目眩心悸、短气而咳者，常与桂枝、白术、甘草同用。心悸失眠:\n治心脾两虚，气血不足之心悸怔忡、健忘失眠，常与人参、当归、酸枣仁等同用:。若心肾不交之神志不宁、惊悸健忘、失眠等，可与党参、远志、石葛蒲同用。', '2023-03-23 16:16:06');
INSERT INTO `drugs` VALUES (8, '葛根', '/drugsImg/8da8d08c-a21c-4933-9e46-9124fbe049f2.jpg', '葛根是一味发散风热药，为豆科植物野葛的干燥根。', '葛根药性甘、辛，凉。归脾、胃、肺经。\n葛根甘辛轻扬升散，平而偏凉能清，入脾、胃经，既透解肌表风热、解肌退热而发表、透发疹斑，又鼓舞脾胃清阳上升而生津止渴、升阳止泻。治项背强痛与阳明头痛最宜，无论寒热虚实、有汗无汗皆可。生用升散清透并生津，爆用长于升举而少清透\n本品含有含黄酮类成分、香豆素类、葛根醇、葛根藤素及异黄酮昔和淀粉等成分。\n功效作用：\n葛根用于外感发热头痛，项背强痛，口渴，消渴，麻疹不透，热痢，泄泻，眩晕头痛，中风偏瘫，痛，酒毒伤中。\n外感发热，项背强痛\n属寒者，常与麻黄、桂枝等同用\n属热者，常与柴胡、黄苓等同用。\n热病口渴及消渴\n治热病津伤口渴，常与天花粉、知母等同用;\n治内热消渴，口渴多饮，常配黄民、麦冬、天花粉等\n麻疹不透\n常与升麻相须为用。\n泻痢\n治脾虚清阳下陷之泄泻，常配伍白术、人参、木香等;治湿热泻痢，常与黄苓、黄连同用。\n中风偏瘫，胸痹心痛\n可单用; 或与丹参、川营同用', '2023-03-23 16:16:23');
INSERT INTO `drugs` VALUES (9, '金银花', '/drugsImg/4d352609-f4b9-449f-8275-17034dab5c34.jpg', '金银花是一种清热解毒药，为忍冬科植物忍冬的干燥花蕾或带初开的花。', '金银花药性甘，寒。归肺、胃、大肠经。\n金银花甘寒清泄，轻扬疏透，清解疏散，入肺、胃、大肠经。既善清解热毒，又善疏散风热。药力颇强而不苦泄，为解散热毒之良药，且味不苦易服。以清为主，清中兼透，凡热毒、风热皆可投用。\n温病各个阶段皆宜，并常配伍连翘，在卫分能透表，气分能清解，营分能透营转气，血分能清解血分热毒。本品含绿原酸、异绿原酸等有机酸，以及木犀草素、忍冬昔等黄酮，此外还含有挥发油、皂昔、肌醇、齐墩果酸、胡萝卜首等成分。\n功效作用：\n金银花用于痛肿疗疮，喉痹，丹毒，热毒血痴，风热感冒，温病发热\n。温热病:本品能清解温热疫毒之邪，有良好的清热解毒作用，可疏散再表之风热，适宜于温热病卫气营血各个阶段。\n·疮痛疗疗:本品为治疗热毒痛肿疗疮的要药，内服、外用皆有效，常与连翘相须为用\n。风热表证: 本品性寒而兼辛香，有清宣疏散之性，为临床常用的疏散风热药\n。热毒咽痛，痴疾:本品清热解毒，适宜于其他热毒病证。\n中药使用需要辨证论治、进行临床个体化治疗。因此，用药前请咨询专业医生，在医生指导下规范用药.', '2023-03-23 16:16:32');
INSERT INTO `drugs` VALUES (10, '党参', '/drugsImg/7899cf1e-1e35-419e-bfbe-c110df69a4f0.jpg', '党参是一种补气药，桔梗科植物党参、素花党参或川党参的干燥根。', '党参药性甘，平。归脾、肺经。\n党参甘补而平，不燥不腻，入脾、肺经。补气之力逊于人参，多用于脾肺气虚之轻症。又兼生津、养血，可治津亏、血虚等证。\n本品主要含党参昔、葡萄糖、菊糖、多糖、党参碱、挥发油、黄酮类、植物醇、微量元素等成分。\n功效作用\n党参用于脾肺气虚，食少倦怠，咳嗽虚喘，气血不足，面色萎黄，心悸气短，津伤口渴，内热消渴。脾肺气虚证:\n。治脾气虚之体虚倦意，食少便清等，常与白术、获苓等同用;。治肺气虚之气短，语声低弱、咳嗽虚喘等，可与黄茂、五味子等同用.气血亏虚及气津两伤证:\n。治气血不足之面色萎黄，头晕心悸，肢倦乏力等，常与黄蔗、当归、熟地黄等同用;。治气津两伤之口渴及内热消渴，常与麦冬、五味子等同用。\n其他功效：\n肺脾气虚所致体倦、咳嗽乏力:\n党参500g (软甜者，切片) ，北沙参250g (切片) ，桂圆肉120g.水煎浓汁，滴水成珠，用瓷器盛贮。每用1酒杯，空心滚水冲服，冲入煎药亦可.气血亏损所致腰酸痛、气短、惊悸、失眠、自汗:\n党参、当归、山药各10g，猪腰500g，酱油、醋、姜、蒜、香油适量\n猪腰切开别去筋膜臊腺，洗净。将洗净的当归、党参、山药与猪腰同置锅内，加水适量，清炖至猪腰熟透捞出猪腰，待冷，切成薄片，放在平盘上，加入酱油、醋、姜丝、蒜未、香油等调料即可食用。经常佐餐食用。', '2023-03-23 16:16:42');
INSERT INTO `drugs` VALUES (11, '川贝母', '/drugsImg/7ccb7bff-8071-4335-ab82-95b05c510407.jpg', '川贝母是一味化痰止咳平喘药，为百合科植物川贝母、暗紫贝母、甘肃贝母、梭砂贝母、太白贝母或瓦布贝母的干燥鳞茎。', '川贝母药性苦、甘，微寒。归肺、心经。\n本品甘润辛散，苦微寒清泄，入肺、心经，为清泄润肺之品。善清肺化痰、润肺止咳，为肺热燥咳及虚劳咳嗽之要药;能开郁散结，治痰热或火郁胸闷、疮肿噱疡。\n本品含多种生物碱，如川贝母含青贝碱、松贝碱甲和松贝碱乙，还含川贝碱和西贝素。暗紫贝母还含松贝宁及蔗糖，甘肃贝母含有氓贝碱甲、氓贝碱乙;梭砂贝母含有白炉贝碱、炉贝碱。\n中药材川贝母具有清热润肺，化痰止咳，散结消痛的功效。用于肺热燥咳，干咳少痰，阴虚劳嗽，痰中带血，瘪疡，乳痛，肺痛。功效作用：\n川贝母用于肺热燥咳，千咳少痰，阴虚劳嗽，痰中带血，瘪疡，乳痛，肺痛。\n热痰、燥痰证\n治风热犯肺，痰热内阻所致的咳嗽痰黄或咯痰不爽者，常与桔梗、枇把叶等同用。\n治阴虚肺热，咳嗽，喘促，口燥咽干者，常与麦冬、百合、款冬花等同用。\n瘪病，乳痈，肺痈\n治痰火郁结之，常与玄参、牡蛎同用\n治热毒璀结之疮疡，乳痛，常配蒲公英、天花粉、连翘等.\n治肺痛咯吐脓血，胸闷咳嗽，常与桔梗、紫苑等同用。', '2023-03-23 16:16:52');
INSERT INTO `drugs` VALUES (12, '甘遂', '/drugsImg/3dd48cb6-69e0-44d7-a337-4636c3ac2a53.jpg', '甘遂是一种泻下药，为大戟科植物甘遂的干燥块根。', '甘遂味苦，寒，有毒;归肺、肾、大肠经。具有泻水逐饮，消肿散结的功效;用于水肿胀满，胸腹积水，痰饮积聚，气逆咳喘，二便不利，风痰癫痛，痛肿疮毒\n现代研究显示，甘遂主要含大载昔、V-大戴醇、甘遂醇、20-表大戟脑、20-去氧巨大载枯醇、巨大戟枯醇6-氧化巨大戟枯醇-B-十二烷酸酶-20-已酸酶、甘遂枯醇A及甘遂醇B，还含维生素B1、柠檬酸、棕相酸、草酸及棕榈酸癸酷等;具有泻下、利尿、抗病毒、抗肿瘤、抗生育等作用。功效作用\n生甘遂药力峻烈，临床多入丸、散剂用，可用于胸腹积水，痰迷癫狂，湿热肿毒。醋甘遂毒性减低，泻下作用相对缓和，可用于腹水胀满，痰饮积聚，气逆喘咳，风痰癫痛，二便不利。\n。水肿，大腹膨胀，胸胁停饮\n本品苦寒性降，善行经隧之水湿，泻水逐饮力峻，药后可连续泻下，同时小便量亦可增，能使体内猪留之水饮随从二便而排出，故凡是水肿，大腹膨胀，胸胁停饮，而正气未衰者均可用之。\n·发狂\n本品苦寒峻下，能荡涤痰涎，故痰热上扰，蒙蔽清窍而癫痛发狂者，常与安神定惊之朱砂研未吞服.\n。痛肿疮毒\n本品外用有解毒消肿散结之功，可用于湿热瑾滞，痛肿疮毒，以甘遂研末调敷患处，或与其他清热解毒药同用，煎汤服。\n名词解释:\n停饮: 饮邪停于心下或隔间，以心痛、胸满、气短、眩是等为常见症的饮证中药使用需要辨证论治、进行临床个体化治疗。因此，用药前请咨询专业医生，在医生指导下规范用药。', '2023-03-23 16:24:27');
INSERT INTO `drugs` VALUES (13, '羌活', '/drugsImg/eabf4da2-f610-40da-9551-46d232dde2e2.jpg', '中药材羌活是一味解表药，为伞形科植物羌活或宽叶羌活的干燥根茎和根。', '羌活药性辛、苦，温。归膀胱、肾经\n羌活辛散苦燥，温通升散，气雄而烈，主入膀胱经，兼入肾经，主表、主上，散在表之游风及寒湿而通利关节止痛，力较强，善治太阳经头痛(后脑疼痛)及颈项痛，特别是肩背肢节疼痛。羌活，始于汉代而与独活混用，唐《药性本草》始将二者分列。\n本品主要含挥发油:G-侧柏烯，a-流烯，B-流烯等;香豆素类:紫花前胡昔，羌活醇，异欧前胡素，8-甲基异欧前胡素;酚性成分: 花椒毒酚。还含脂肪酸、氨基酸、糖类等。具有解表散寒，祛风除湿，止痛的功必。\n功效作用：\n羌活用于风寒感冒，头痛项强，风湿痹痛，肩背酸痛。\n风寒夹湿表证\n症见恶寒发热，无汗，头痛项强、肢体酸痛等。常与防风、细辛、川营等同用。\n痹证\n治风寒湿痹，症见肩项臂痛，举动艰难，手足麻木等，常与防风、姜黄、当归等同用。\n其他功效：\n羌活常用药膳方选如下:\n骨节疼痛，筋脉拘挛:或中风半身不遂，口眼 斜，肢体麻木:\n。白花蛇1条，羌活60g，当归身60g，天麻60g，秦60g，五加皮60g，防风30g，糯米酒4L。。白花蛇以酒洗、润透，去骨刺，取肉;各药切碎，以绢袋盛之，放入酒坛内;将酒坛放于大锅内，水煮1日，取起埋阴地，7日取出。每次饮1~ 2杯 (30~ 60mL)。\n风湿肩背疼痛:\n姜黄80g，木瓜160g，羌活80g，黄酒1L，密封7天即成。每日3次，每次饮10mL。\n注:中药材的使用须辨证论治，应在专业中医指导下使用，不可自行随意使用，更不可随意听信中药偏方和广告宣传。', '2023-03-23 16:17:25');
INSERT INTO `drugs` VALUES (14, '忍冬藤', '/drugsImg/260a4458-0f57-4a63-89c6-ffa385b8be9d.jpg', '忍冬藤是一种清热药，为忍冬科植物忍冬的干燥茎枝。以外皮枣红色、质嫩带叶者为佳。', '忍冬藤味甘，性寒，归肺、胃经。\n忍冬藤具有清热解毒，疏风通络的功效。主要用于温病发热，热毒血痴，痛肿疮疡，风湿热痹，关节红肿热痛,\n主要含有绿原酸、异绿原酸等有机酸类，懈皮素、木犀草昔等黄酮类以及忍冬苦昔A等皂昔等成分。功效作用：\n忍冬藤用于温病发热，热毒血痴，痛肿疮疡，风湿热痹，关节红肿热痛。\n清热解毒：本品味甘，性寒，有清热解毒之功，常用于温病发热 、热毒血痴、痈肿疮毒等证。舒筋活络\n专治热痹。热痹为病，热毒流注关节，或内有蕴热更感风寒湿邪，与热相搏，或寒痹日久，郁而化热。。忍冬藤辛寒，藤类延，舒筋活络，泄热通痹。补虚疗风：本品辛甘微寒，药性平缓，补虚疗风，长年益寿，古为养生妙品，多服久服，有乌须发、驻容颜的效果.散瘀止痛\n忍冬藤具有清里热、散外邪、祛瘀止痛之效。', '2023-03-23 16:17:33');
INSERT INTO `drugs` VALUES (15, '天麻', '/drugsImg/1.jpg', '中药材天麻是一味平肝息风药，为兰科植物天麻的千燥块茎。', '天麻药性甘，平，归肝经。\n天麻甘缓质重，柔润不燥，性平不偏，专归于肝。善息风止痉、平抑肝阳，治肝阳、肝风诸证，无论寒热虚实皆宜。能祛风通络，治痹痛肢麻与手足不遂。\n本品含酚类成分、脂肪酸类成分、多糖，还含有胡萝卜昔，多种氨基酸，多种微量元素，具有息风止痉，平抑肝阳，祛风通络的功能。功效作用\n天麻用于小儿惊风，癫痈抽搐，破伤风，头痛眩晕，手足不遂，肢体麻木，风湿痹痛。肝风内动证\n。治小儿急慢惊风，大人中风涎雍，半身不遂，言语艰难等，可与半真、获苓、白术等同用:。若治破伤风，痉挛抽搐、角弓反张等，可与天南星、白附子、防风等配伍。眩晕头痛\n。治肝阳上亢之头痛、眩晕，可单用炖服，或研未吞服;或与钩藤相须为用:。若治风痰上扰之眩是头痛，可与半夏、获苓、白术等同用。\n肢体麻木，手足不遂，风湿瘦痛\n常与独活、杜仲、牛膝等同用。\n其他功效：\n高血压，目眩，头痛 (肝阳上亢型)\n天麻2g，鸡蛋1个，将天麻切片放锅内加水煮30分钟后，打入鸡蛋蒸熟后即可食用。每日或隔日1次。\n痰浊上扰型眩晕，天麻10g，豆腐适量。同加水入锅，煮沸即成。', '2023-04-07 15:25:49');

-- ----------------------------
-- Table structure for propose
-- ----------------------------
DROP TABLE IF EXISTS `propose`;
CREATE TABLE `propose`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '留言姓名',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '联系邮箱',
  `subject` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '留言主题',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '留言信息',
  `addtime` datetime NOT NULL DEFAULT CURRENT_timestamp ON UPDATE CURRENT_timestamp COMMENT '添加时间',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of propose
-- ----------------------------
INSERT INTO `propose` VALUES (1, '路人甲', 'dd', 'dd', '啊啊', '2023-03-19 17:19:01', 3);
INSERT INTO `propose` VALUES (2, 'dd', 'dd', 'dd', 'aaaaa', '2023-03-19 17:21:53', 3);
INSERT INTO `propose` VALUES (3, 'dd', 'dd', 'dd', '1212', '2023-03-19 17:23:53', 3);
INSERT INTO `propose` VALUES (5, '1', '1', '1', '', '2023-03-28 20:41:53', 1);
INSERT INTO `propose` VALUES (10, '2', '2', '2', '2', '2023-04-07 15:17:19', 5);
INSERT INTO `propose` VALUES (8, '1', '1', '1', '1', '2023-04-07 14:38:46', 5);

-- ----------------------------
-- Table structure for reservation_dot
-- ----------------------------
DROP TABLE IF EXISTS `reservation_dot`;
CREATE TABLE `reservation_dot`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reservation_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '预约的医生名',
  `symptom` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '症状',
  `reservation_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '预约时间',
  `time_period` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '预约时段',
  `reservation_age` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '预约人年龄',
  `reservation_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '预留电话',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '预约人的姓名',
  `state` int(1) NOT NULL COMMENT '预约状态 0已取消 1已预约 2已完成',
  `doctor_id` int(11) NOT NULL COMMENT '预约医生ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reservation_dot
-- ----------------------------
INSERT INTO `reservation_dot` VALUES (8, '王秀', '上海', '2023-04-08', '9:00-10:00', '58', '18877758559', '老管理', 0, 1, 4);
INSERT INTO `reservation_dot` VALUES (9, '王秀', '上海', '2023-04-07', '15:00-16:00', '58', '18877758559', '老管理', 1, 1, 4);
INSERT INTO `reservation_dot` VALUES (10, '王秀', '杭州', '2023-04-07', '11:00-12:00', '58', '18877758559', '老管理', 0, 1, 4);
INSERT INTO `reservation_dot` VALUES (11, '李怡泉', '上海', '2023-04-07', '15:00-16:00', '58', '18877758559', '老管理', 1, 6, 4);
INSERT INTO `reservation_dot` VALUES (12, '李怡泉', '北京', '2023-04-07', '15:00-16:00', '58', '18877758559', '老管理', 1, 6, 4);
INSERT INTO `reservation_dot` VALUES (13, '李怡泉', '北京', '2023-04-07', '15:00-16:00', '58', '18877758559', '老管理', 0, 6, 4);
INSERT INTO `reservation_dot` VALUES (14, '李怡泉', '北京', '2023-04-11', '9:00-10:00', '', '13089004385', '小范', 1, 6, 5);
INSERT INTO `reservation_dot` VALUES (15, '王秀', '头疼', '2023-04-14', '17:00-18:00', '58', '18877758559', '老管理', 0, 1, 4);
INSERT INTO `reservation_dot` VALUES (16, '王秀', '耳鸣', '2023-04-13', '17:00-18:00', '', '13089004385', '小范', 0, 1, 5);

-- ----------------------------
-- Table structure for reservation_yc
-- ----------------------------
DROP TABLE IF EXISTS `reservation_yc`;
CREATE TABLE `reservation_yc`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '预约人姓名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '预约手机号',
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '预约时间',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reservation_yc
-- ----------------------------
INSERT INTO `reservation_yc` VALUES (1, '路人甲', '18877728559', '2023-03-20 00:16:27', 3);

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `doctor_id` int(11) NULL DEFAULT NULL COMMENT '医生id',
  `status` int(1) NULL DEFAULT NULL COMMENT '状态 1、不可约',
  `time_period` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '时段',
  `signal_source` int(11) NULL DEFAULT NULL COMMENT '剩余号源',
  `default_source` int(11) NULL DEFAULT NULL COMMENT '默认号源',
  `booking_time` timestamp NULL DEFAULT NULL COMMENT '预约时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES (1, 6, NULL, '15:00-16:00', 9, NULL, '2023-04-06 16:00:00', '2023-04-06 04:40:39');
INSERT INTO `schedule` VALUES (2, 6, NULL, '9:00-10:00', 11, NULL, '2023-04-10 16:00:00', '2023-04-07 01:53:33');
INSERT INTO `schedule` VALUES (3, 1, NULL, '17:00-18:00', 2, NULL, '2023-04-13 16:00:00', '2023-04-07 04:22:48');
INSERT INTO `schedule` VALUES (4, 1, NULL, '17:00-18:00', 1, NULL, '2023-04-12 16:00:00', '2023-04-07 05:37:07');

-- ----------------------------
-- Table structure for symptom
-- ----------------------------
DROP TABLE IF EXISTS `symptom`;
CREATE TABLE `symptom`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '症状',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of symptom
-- ----------------------------
INSERT INTO `symptom` VALUES (1, '头疼');
INSERT INTO `symptom` VALUES (7, '耳鸣');
INSERT INTO `symptom` VALUES (8, '感冒');
INSERT INTO `symptom` VALUES (9, '发烧');
INSERT INTO `symptom` VALUES (10, '流鼻涕');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '角色',
  `power` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '权限(0是管理，1是普通用户，2是医生，3是专家)',
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '密码的UUID',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户是否被禁用，0为正常，1为禁用',
  `working_date` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '工作日期',
  `signal_source` int(11) NULL DEFAULT NULL COMMENT '默认号源',
  `department_id` int(11) NULL DEFAULT NULL COMMENT '所属科室id(医生、专家才有)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '3', '6512bd43d9caa6e02c990b0a82652dca', '医生', '2', '1', '0', '周一,周二,周三,周四,周五', 1, 2);
INSERT INTO `user` VALUES (4, '1', '1', '管理员', '0', '1', '0', NULL, NULL, NULL);
INSERT INTO `user` VALUES (5, 'u', '6512bd43d9caa6e02c990b0a82652dca', '普通用户', '1', '1', '0', NULL, NULL, NULL);
INSERT INTO `user` VALUES (6, '2', '3a3eee5e496b439b0b3ca582d746c891', '专家', '3', '3775e805-0ac8-41ab-93e3-799074b75d7d', '0', '周二', 12, NULL);
INSERT INTO `user` VALUES (7, '4', '6512bd43d9caa6e02c990b0a82652dca', '医生', '2', '1', '0', '周一,周二,周三,周四,周五', 1, 2);
INSERT INTO `user` VALUES (8, '5', '6512bd43d9caa6e02c990b0a82652dca', '医生', '2', '1', '0', '周一,周二,周三,周四,周五', 1, 2);
INSERT INTO `user` VALUES (9, '6', '6512bd43d9caa6e02c990b0a82652dca', '专家', '3', '1', '0', '周一,周二,周三,周四,周五', 1, 2);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `height` double NULL DEFAULT NULL COMMENT '身高',
  `weight` double NULL DEFAULT NULL COMMENT '体重',
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '介绍',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
  `address_id` int(11) NULL DEFAULT NULL COMMENT '地址ID',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '头像地址',
  `user_id` int(11) NOT NULL COMMENT '账号ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, '王秀', '男', 85, 165, 80, NULL, '1859564556', 1, '/drugsImg/4.jpg', 1);
INSERT INTO `user_info` VALUES (2, '李怡泉', '男', 18, 180, 165, '副教授、云南省名中医、李氏中医学术流派传人。专家擅长：胃肠病、肝病、肾病 消化系统疾病：慢性胃炎、十二指肠胃炎、 胆囊炎、乙肝、肝硬化（腹水）、腹泻、便秘、结肠炎； 泌尿系统疾病：肾炎、尿路感染、肾结石、睾丸炎、附睾炎。', '18877728559', NULL, '/drugsImg/1.jpg', 6);
INSERT INTO `user_info` VALUES (3, '老管理', '男', 58, 160, 165, NULL, '18877758559', 1, NULL, 4);
INSERT INTO `user_info` VALUES (4, '小范', '保密', NULL, 123, 0, NULL, '13089004385', NULL, NULL, 5);
INSERT INTO `user_info` VALUES (5, '李天', '男', 85, 165, 80, NULL, '1859564556', 1, '/drugsImg/2.jpg', 7);
INSERT INTO `user_info` VALUES (6, '张俐', '男', 85, 165, 80, NULL, '1859564556', 1, '/drugsImg/3.jpg', 8);
INSERT INTO `user_info` VALUES (7, '于嘉豪', '男', 85, 165, 80, '二级教授、云南省名中医、博士研究生导师、加拿大多伦多大学访问学者、国家中医药管理局及省级重点学科学术带头人。\r\n                                        专家擅长：擅长诊治中医内、妇、儿、皮肤科及杂病的疑难病证，过敏性疾病，如：过敏性皮炎、湿疹、荨麻疹。', '1859564556', 1, '/drugsImg/5.jpg', 9);

SET FOREIGN_KEY_CHECKS = 1;
